package com.panjoy.classloader;


import java.io.*;
import java.lang.reflect.Method;

public class ClassLoader2 extends ClassLoader {
    private String path; // 加载类的路径
    private final String fileType = ".class"; // .class文件扩展名

    public ClassLoader2() {
    }

    public ClassLoader2(ClassLoader parent) {
        super(parent);
    }

    public void setPath(String path) {
        this.path = path;
    }

    private byte[] loadClassData(String name) {

        System.out.println("load classloader");
        InputStream in = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            name = name.replace(".", "\\");
            in = new BufferedInputStream(new FileInputStream(new File(path
                    + name + fileType)));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = in.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(in!=null)
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(baos!=null)
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass ---------");
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) throws  Exception{
        ClassLoader2 loader1 = new ClassLoader2();
       // ClassLoader2 loader2 = new ClassLoader2(loader1);
        //loader2.setPath("D://data//");
        //test01(loader1);  // getParent~~~:com.test.AppClassLoader
       // test01(loader2);  // getParent~~~:com.test.ClassLoaderTest02
        test02(loader1);
    }

    /**
     * 正常使用AppClassLoader
     */
    public static void test01(ClassLoader2 loader) throws Exception {

        System.out.println("classLoader~~~:" +
                ClassLoader2.class.getClassLoader().getClass().getName());
        System.out.println("getParent~~~:" +
                loader.getParent().getClass().getName());
        Class<?> clazz = loader.loadClass("com.panjoy.classloader.Animal"); // AppClassLoader
        System.out.println("clazz~~~:"
                + clazz.getClassLoader().getClass().getName());
        System.out.println("Animal~~~:" + Animal.class.getClassLoader());
        Animal animal=(Animal) clazz.newInstance();
        animal.say("eed");
        Object animalObj = clazz.newInstance();
        Method animalSay = clazz.getMethod("say",String.class);
        animalSay.invoke(animalObj,"nima");
    }
    /**
     * 使用自定義ClassLoader
     * 注：（1）需要先屏蔽classpath下的Animal.class（如重命名）；（2）copy .class到其它目錄（如D:\temp1）
     */
    public static void test02(ClassLoader2 loader) throws Exception {
        loader.setPath("D://data//");
        System.out.println("classLoader~~~:" +
                ClassLoader2.class.getClassLoader().getClass().getName());
        System.out.println("getParent~~~:" +
                loader.getParent().getClass().getName());
        Class<?> clazz = loader.findClass("com.panjoy.classloader.Animal"); // ClassLoaderTest02
        System.out.println("clazz~~~:" +
                clazz.getClassLoader().getClass().getName());
        Object animalObj = clazz.newInstance(); // classloader不一致, 通过reflect调用
        Method animalSay = clazz.getMethod("say",String.class);
        animalSay.invoke(animalObj,"shazi");
    }
}
