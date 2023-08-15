
const $container = $('table.history-container');
const $pageButtonBox = $('.page-button-box');
const $searchInput = $('input.search-input');

const ELEMENT_SIZE_PER_PAGE = 10;
const PAGE_SET_SIZE = 10;

class AdministratorService {
    constructor(requestURL, header, appender) {
        this.requestURL = requestURL;
        this.header = header;
        this.appender = appender;
        this.page = undefined;
        this.keyword = '';

        this.shiftPage(1);

        $searchInput.on('keyup', (e) => {
            if(e.keyCode !== 13) return;
            this.keyword = $searchInput.val();
            this.shiftPage(1);
        });
    }

    getOffset() {
        if(this.page) {
            return Math.floor(this.page.number / PAGE_SET_SIZE)
        }
        return -1;
    }

    getPagePromise(page) {
        const req = this.requestURL + "?" +
            (page != undefined ? `size=${ELEMENT_SIZE_PER_PAGE}&page=` + page + "&" : "") +
            (this.keyword != '' ? "keyword=" + this.keyword : "");
        return fetch(req).then(response => response.json());
    }

    /**
     * @param page 1부터 카운트
     */
    shiftPage(page) {
        page = page - 1;
        this.getPagePromise(page).then(json => {
            let html = this.header;
            this.page = json;

            console.log(json);

            if(this.page.content.length == 0) {
                $container.html(html + `<tr class="not-found"><div class="test">ㅁㅈㅇ</div>검색 결과가 없습니다.</tr>`);
                $pageButtonBox.html("");
                return;
            }

            this.page.content.forEach(e => html += this.appender(e));
            $container.html(html);

            $('.history-container tr').each((i, e) => {
                if(i === 0) return;
                $(e).on('click', () => location.href = `admin/trade/detail?id=${this.page.content[i - 1].id}`);
            });

            this.setPageButtons();
        });
    }

    setPageButtons() {
        let pageOffset = this.getOffset();
        let lastOffset = Math.floor(this.page.totalPages / 10);

        //settings =====================================================
        let html = '';

        html += `
            <div class="${pageOffset > 0 ? 'prev' : 'blocked'}">
                <div class="page-button-margin">
                    <div>
                        <img src="/image/admin/left_icon.png" class="left-button">
                    </div>
                </div>
            </div>
        `;

        for (let i = 0; i < PAGE_SET_SIZE; i++) {
            let idx = (pageOffset) * PAGE_SET_SIZE + i + 1;
            if(idx > this.page.totalPages) break;

            html += `
                <div class="page-button">
                    <div class="page-button-margin">
                        <div>
                            <span>${idx}</span>
                        </div>
                    </div>
                </div>
            `;
        }

        html += `
            <div class="${pageOffset < lastOffset ? 'next' : 'blocked'}">
                <div class="page-button-margin">
                    <div>
                        <img src="/image/admin/right_icon.png" class="right-button">
                    </div>
                </div>
            </div>
        `;

        $pageButtonBox.html(html);

        //events ====================================================
        $('.page-button').each((i, button) => {
            let $button = $(button);
            let idx = $button.text();
            if(this.page.number + 1 == idx) $button.addClass("page-button-active");
            $button.on('click', () => {
                $('.page-button-active').removeClass("page-button-active");
                $button.addClass("page-button-active");
                this.shiftPage(idx);
            });
        });

        //< 이전 세트로
        $('.prev').on('click', () => {
            let prevPageNumber = (this.getOffset() - 1) * PAGE_SET_SIZE;
            this.shiftPage(prevPageNumber);
        });

        //> 다음 세트로
        $('.next').on('click', () => {
            let nextPageNumber = (this.getOffset() + 1) * PAGE_SET_SIZE + 1;
            this.shiftPage(nextPageNumber);
        });
    }
}

