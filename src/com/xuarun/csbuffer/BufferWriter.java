package com.xuarun.csbuffer;

import java.io.*;

public class BufferWriter extends BufferedOutputStream {
    private int written;

    public BufferWriter(OutputStream out) {
        super(out);
    }

    public final void writeBoolean(boolean _v) throws IOException {
        super.write(_v ? 1 : 0);
        this.incCount(1);
    }

    public final void writeByte(int _v) throws IOException {
        super.write(_v);
        this.incCount(1);
    }

    public final void writeShort(int _v) throws IOException {
        super.write(_v >> 0 & 255);
        super.write(_v >> 8 & 255);
        this.incCount(2);
    }

    public final void writeChar(int _v) throws IOException {
        super.write(_v >> 0 & 255);
        super.write(_v >> 8 & 255);

        this.incCount(2);
    }

    public final void writeInt(int _v) throws IOException {
        super.write(_v >> 0 & 255);
        super.write(_v >> 8 & 255);
        super.write(_v >> 16 & 255);
        super.write(_v >> 24 & 255);

        this.incCount(4);
    }

    public final void writeLong(long v) throws IOException {
        super.write((byte) ((int) (v >> 0)));
        super.write((byte) ((int) (v >> 8)));
        super.write((byte) ((int) (v >> 16)));
        super.write((byte) ((int) (v >> 24)));
        super.write((byte) ((int) (v >> 32)));
        super.write((byte) ((int) (v >> 40)));
        super.write((byte) ((int) (v >> 48)));
        super.write((byte) ((int) (v >> 56)));

        this.incCount(8);
    }

    public final void writeString(String _str) throws IOException {
        byte[] bytes = _str.getBytes(Global.charsetName);
        int len = bytes.length;
        super.write(len);
        super.write(bytes);

        this.incCount(len);
    }

    public final void writeString(String _str, String _charsetName) throws IOException {
        byte[] bytes = _str.getBytes(_charsetName);
        int len = bytes.length;
        super.write(len);
        super.write(bytes);

        this.incCount(len);
    }

    public final void incCount(int _value) {
        written += _value;
    }

    public final int size() {
        return written;
    }
}
