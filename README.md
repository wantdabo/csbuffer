# CSBuffer
因为 Java 与 C# 二进制流读取的顺序不一致，因此写出该转换库，用于转换方便。

读取顺序的方式，用的是 C# 的规则，因此使用 Java 重写。



### **示例**

```java
import java.io.IOException;
import java.net.Socket;
import com.xuarun.csbuffer.BufferReader;
import com.xuarun.csbuffer.BufferWriter;

public class Test {
    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1224);

        // 写入
        BufferWriter bw = new BufferWriter(socket.getOutputStream());
        bw.writeByte(1);
        bw.writeInt(10086);
        bw.writeString("Hello World.");

        // 读取
        BufferReader br = new BufferReader(socket.getInputStream());
        byte b = br.readByte();
        int i = br.readInt();
        String str = br.readString();
    }
}
```

## BufferReader  `(二进制流读取类)`

对应 C# （BinaryReader）

继承于 BufferedInputStream

```java
// 读取布尔值, 1 个字节
public final boolean readBoolean();
// 读取 Byte, 1 个字节
public final byte readByte();
// 读取无符号 Byte, 1 个字节
public final byte readUnsignedByte();
// 读取 Short, 2 个字节
public final short readShort();
// 详细请查看源码
.....
```

## BufferWriter  `(二进制流写入类)`

对应 C# （BinaryWriter）

继承于 BufferedOutputStream

```java
// 写入布尔值, 1 个字节
public final void writeBoolean();
// 写入 Byte, 1 个字节
public final void writeByte();
// 写入 Short, 2 个字节
public final void writeShort();
// 写入 Char, 2 个字节
public final void writeChar();
// 详细请查看源码
.....
```

