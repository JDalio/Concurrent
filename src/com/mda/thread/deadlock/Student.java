package com.mda.thread.deadlock;

public class Student
{
    private Teacher teacher;
    private int process;

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public synchronized int getProcess()
    {
        return process;
    }

    public void setProcess(int process)
    {
        this.process = process;
        if (process == 100)
        {
            teacher.studentNotify(this);
        }
    }
}
