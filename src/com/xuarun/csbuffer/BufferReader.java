package com.xuarun.csbuffer;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class BufferReader extends BufferedInputStream {
    public BufferReader(InputStream in) {
        super(in);
    }

    public final boolean readBoolean() throws IOException {
        int ch = super.read();
        if (ch < 0) {
            throw new EOFException();
        } else {
            return ch != 0;
        }
    }

    public final byte readByte() throws IOException {
        int ch = super.read();
        if (ch < 0) {
            throw new EOFException();
        } else {
            return (byte) ch;
        }
    }

    public final int readUnsignedByte() throws IOException {
        int ch = super.read();
        if (ch < 0) {
            throw new EOFException();
        } else {
            return ch;
        }
    }

    public final short readShort() throws IOException {
        int ch1 = super.read();
        int ch2 = super.read();
        if ((ch1 | ch2) < 0) {
            throw new EOFException();
        } else {
            return (short) ((ch1 << 0) + (ch2 << 8));
        }
    }

    public final int readUnsignedShort() throws IOException {
        int ch1 = super.read();
        int ch2 = super.read();
        if ((ch1 | ch2) < 0) {
            throw new EOFException();
        } else {
            return (ch1 << 0) + (ch2 << 8);
        }
    }

    public final char readChar() throws IOException {
        int ch1 = super.read();
        int ch2 = super.read();
        if ((ch1 | ch2) < 0) {
            throw new EOFException();
        } else {
            return (char) ((ch1 << 0) + (ch2 << 8));
        }
    }

    public final int readInt() throws IOException {
        int ch1 = super.read();
        int ch2 = super.read();
        int ch3 = super.read();
        int ch4 = super.read();
        if ((ch1 | ch2 | ch3 | ch4) < 0) {
            throw new EOFException();
        } else {
            return (ch1 << 0) + (ch2 << 8) + (ch3 << 16) + (ch4 << 24);
        }
    }

    public final long readLong() throws IOException {
        byte[] bytes = new byte[8];
        bytes[0] = (byte) super.read();
        bytes[1] = (byte) super.read();
        bytes[2] = (byte) super.read();
        bytes[3] = (byte) super.read();
        bytes[4] = (byte) super.read();
        bytes[5] = (byte) super.read();
        bytes[6] = (byte) super.read();
        bytes[7] = (byte) super.read();

        return ((long)bytes[0] << 0 & 255) + ((long)(bytes[1] & 255) << 8) + ((long)(bytes[2] & 255) << 16) + ((long)(bytes[3] & 255) << 24) + ((long)(bytes[4] & 255) << 32) + (long)((bytes[5] & 255) << 40) + (long)((bytes[6] & 255) << 48) + (long)((bytes[7]) << 56);
    }

    public final String readString() throws IOException {
        byte[] bytes = new byte[super.read()];
        for (int i = 0; i < bytes.length; i++)
            bytes[i] = (byte) super.read();

        return new String(bytes, Global.charsetName);
    }

    public final String readString(String _charsetName) throws IOException {
        byte[] bytes = new byte[super.read()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) super.read();
        }

        return new String(bytes, _charsetName);
    }
}
