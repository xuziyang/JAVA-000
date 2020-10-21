import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader(){
            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".xlass";
                try{
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null) {
                        return super.loadClass(name);
                    }
                    byte[] bs = new byte[is.available()];
                    is.read(bs);

                    for (int i = 0; i < bs.length; i++) {
                        bs[i] = (byte) (255 - bs[i]);
                    }
                    return defineClass(name, bs, 0, bs.length);
                }catch(IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Hello hello = (Hello) myLoader.loadClass("Hello").newInstance();
        hello.hello();
    }
    
}
