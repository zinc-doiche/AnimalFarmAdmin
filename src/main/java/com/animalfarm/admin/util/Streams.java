package com.animalfarm.admin.util;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Streams {
    public static void useOutputStream(BiConsumer<ByteArrayOutputStream, BukkitObjectOutputStream> use) {
        try(ByteArrayOutputStream bs = new ByteArrayOutputStream(); BukkitObjectOutputStream os = new BukkitObjectOutputStream(bs)) {
            use.accept(bs, os);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static <T> T useInputStream(byte[] byteArray , BiFunction<ByteArrayInputStream, BukkitObjectInputStream, T> use) {
        try(ByteArrayInputStream ais = new ByteArrayInputStream(byteArray); BukkitObjectInputStream ois = new BukkitObjectInputStream(ais)) {
            return use.apply(ais, ois);
        } catch(IOException e) {
            throw new RuntimeException();
        }
    }

    public static void writeItem(BukkitObjectOutputStream bukkitObjectOutputStream, ItemStack item) throws IOException {
        bukkitObjectOutputStream.writeObject(item.serialize());
        bukkitObjectOutputStream.flush();
    }

    public static String getEncodedItem(ByteArrayOutputStream byteArrayOutputStream) {
        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }

    @SuppressWarnings("unchecked")
    public static ItemStack decodeAsItem(Base64.Decoder decoder, String itemString) {
        return useInputStream(decoder.decode(itemString),  (arrayInputStream, input) -> {
            try {
                return ItemStack.deserialize((Map<String, Object>) input.readObject());
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}