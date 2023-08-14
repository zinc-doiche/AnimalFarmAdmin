package com.animalfarm.admin.util

import org.bukkit.inventory.ItemStack
import org.bukkit.util.io.BukkitObjectInputStream
import org.bukkit.util.io.BukkitObjectOutputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.*

internal fun useOutputStream(use: (ByteArrayOutputStream, BukkitObjectOutputStream) -> Unit) {
    ByteArrayOutputStream().use { bs ->
        BukkitObjectOutputStream(bs).use { os ->
            use(bs, os)
        }
    }
}

internal fun <T> useInputStream(byteArray: ByteArray, use: (ByteArrayInputStream, BukkitObjectInputStream) -> T): T {
    ByteArrayInputStream(byteArray).use { bs ->
        BukkitObjectInputStream(bs).use { input ->
            return use(bs, input)
        }
    }
}

internal fun BukkitObjectOutputStream.writeItem(item: ItemStack) {
    item.serialize().let(this::writeObject)
    flush()
}

internal val ByteArrayOutputStream.encodedItem: String
    get() = Base64.getEncoder().encodeToString(toByteArray())

@Suppress("UNCHECKED_CAST")
internal fun Base64.Decoder.decodeAsItem(src: String): ItemStack {
    return useInputStream(decode(src)) { _, input -> ItemStack.deserialize(input.readObject() as MutableMap<String, Any>) }
}