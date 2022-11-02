package com.jnu.hw6.data;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.jnu.hw6.MainActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataSaver {
    public void Save(Context context, ArrayList<bookitem> data)
    {
        try {
            Log.e("aaa","saver");
            FileOutputStream dataStream=context.openFileOutput("mydata.dat",Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(dataStream);
            out.writeObject(data);
            out.close();
            dataStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @NonNull
    public ArrayList<bookitem> Load(Context context)
    {
        ArrayList<bookitem> data=new ArrayList<>();
        try {
            FileInputStream fileIn = context.openFileInput("mydata.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            data = (ArrayList<bookitem>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Toast.makeText(MainActivity.this, "触发事件", Toast.LENGTH_SHORT).show();
        Log.e("111","success");
        return data;
    }
}
