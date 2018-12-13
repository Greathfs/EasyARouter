package com.hfs.libcommon.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import com.hfs.libcommon.EasyApplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * time: 15/7/17
 * description: sharedPreference管理类
 *
 * @author sunjianfei
 */
public class PreferenceUtil {

    private static SharedPreferences mInstance;

    private static SharedPreferences getInstance() {
        if (mInstance == null) {
            mInstance = EasyApplication.getInstance().getSharedPreferences("SharePreferenceUtils", Context.MODE_PRIVATE);
        }
        return mInstance;
    }


    /**
     * 存入字符串
     *
     * @param key     字符串的键
     * @param value   字符串的值
     */
    public static void putString(String key, String value) {
        SharedPreferences preferences = getInstance();
        //存入数据
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * 获取字符串
     *
     * @param key     字符串的键
     * @return 得到的字符串
     */
    public static String getString(String key) {
        SharedPreferences preferences = getInstance();
        return preferences.getString(key, "");
    }

    /**
     * 获取字符串
     *
     * @param key     字符串的键
     * @param value   字符串的默认值
     * @return 得到的字符串
     */
    public static String getString(String key, String value) {
        SharedPreferences preferences = getInstance();
        return preferences.getString(key, value);
    }

    /**
     * 保存布尔值
     *
     * @param key     键
     * @param value   值
     */
    public static void putBoolean(String key, boolean value) {
        SharedPreferences sp = getInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * 获取布尔值
     *
     * @param key      键
     * @param defValue 默认值
     * @return 返回保存的值
     */
    public static boolean getBoolean(String key, boolean defValue) {
        SharedPreferences sp = getInstance();
        return sp.getBoolean(key, defValue);
    }

    /**
     * 保存long值
     *
     * @param key     键
     * @param value   值
     */
    public static void putLong(String key, long value) {
        SharedPreferences sp = getInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * 获取long值
     *
     * @param key      键
     * @param defValue 默认值
     * @return 保存的值
     */
    public static long getLong(String key, long defValue) {
        SharedPreferences sp = getInstance();
        return sp.getLong(key, defValue);
    }

    /**
     * 保存int值
     *
     * @param key     键
     * @param value   值
     */
    public static void putInt(String key, int value) {
        SharedPreferences sp = getInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * 获取long值
     *
     * @param key      键
     * @param defValue 默认值
     * @return 保存的值
     */
    public static int getInt(String key, int defValue) {
        SharedPreferences sp = getInstance();
        return sp.getInt(key, defValue);
    }

    /**
     * 保存对象
     *
     * @param key     键
     * @param obj     要保存的对象（Serializable的子类）
     * @param <T>     泛型定义
     */
    public static <T extends Serializable> void putObject(String key, T obj) {
        try {
            put(key, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象
     *
     * @param key     键
     * @param <T>     指定泛型
     * @return 泛型对象
     */
    public static <T extends Serializable> T getObject(String key) {
        try {
            return (T) get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 存储List集合
     *
     * @param key     存储的键
     * @param list    存储的集合
     */
    public static void putList(String key, List<? extends Serializable> list) {
        try {
            put(key, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取List集合
     *
     * @param key     键
     * @param <E>     指定泛型
     * @return List集合
     */
    public static <E extends Serializable> List<E> getList(String key) {
        try {
            return (List<E>) get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 存储Map集合
     *
     * @param key     键
     * @param map     存储的集合
     * @param <K>     指定Map的键
     * @param <V>     指定Map的值
     */
    public static <K extends Serializable, V extends Serializable> void putMap(String key, Map<K, V> map) {
        try {
            put(key, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <K extends Serializable, V extends Serializable> Map<K, V> getMap(String key) {
        try {
            return (Map<K, V>) get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 存储对象
     */
    private static void put(String key, Object obj)
            throws IOException {
        if (obj == null) {//判断对象是否为空
            return;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        // 将对象放到OutputStream中
        // 将对象转换成byte数组，并将其进行base64编码
        String objectStr = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
        baos.close();
        oos.close();

        putString(key, objectStr);
    }

    /**
     * 获取对象
     */
    private static Object get(String key)
            throws IOException, ClassNotFoundException {
        String wordBase64 = getString(key);
        // 将base64格式字符串还原成byte数组
        if (TextUtils.isEmpty(wordBase64)) { //不可少，否则在下面会报java.io.StreamCorruptedException
            return null;
        }
        byte[] objBytes = Base64.decode(wordBase64.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(objBytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        // 将byte数组转换成product对象
        Object obj = ois.readObject();
        bais.close();
        ois.close();
        return obj;
    }
}
