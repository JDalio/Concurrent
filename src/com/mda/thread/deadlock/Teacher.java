package com.mda.thread.deadlock;


import java.util.List;

public class Teacher
{
    List<Student>students;

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public synchronized void studentNotify(Student student)
    {
        students.remove(student);
    }

    public synchronized void getAllStudentStatus()
    {
        for(Student student:students)
        {
            System.out.println(student.getProcess());
        }
    }
}
