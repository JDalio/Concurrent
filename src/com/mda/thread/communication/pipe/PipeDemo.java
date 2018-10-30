package com.mda.thread.communication.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class ReadThread extends Thread
{
    private PipedInputStream in;

    public ReadThread(PipedInputStream in)
    {
        this.in = in;
    }

    @Override
    public void run()
    {
        int i=0;

        try
        {
            while((i=in.read())!=-1)
            {
                System.out.println(i);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                in.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}

class WriteThread extends Thread
{
    private PipedOutputStream out;

    public WriteThread(PipedOutputStream out)
    {
        this.out = out;
    }

    @Override
    public void run()
    {
        byte[]bytes={1,2,3,4,5};

        try
        {
            out.write(bytes);
            out.flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }

    }
}
public class PipeDemo
{
    public static void main(String[] args)
    {
        PipedInputStream in=new PipedInputStream();
        PipedOutputStream out=new PipedOutputStream();

        try
        {
            in.connect(out);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        new ReadThread(in).start();
        new WriteThread(out).start();

    }
}
