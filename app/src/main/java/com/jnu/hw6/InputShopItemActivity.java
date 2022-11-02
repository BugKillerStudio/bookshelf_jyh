//package com.jnu.hw6;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class InputShopItemActivity extends AppCompatActivity {
//
//    public static final int RESULT_CODE_SUCCESS = 666;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_input_shop_item);
//
//        EditText editTextTitle=findViewById(R.id.edittext_shop_item_title);
//        EditText editTextPrice=findViewById(R.id.edittext_shop_item_price);
//
//        Button buttonOk=findViewById(R.id.button_ok);
//        buttonOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent();
//                Bundle bundle=new Bundle();
//                bundle.putString("title",editTextTitle.getText().toString());
//                double price=Double.parseDouble( editTextPrice.getText().toString());
//                bundle.putDouble("price",price);
//
//                intent.putExtras(bundle);
//                setResult(RESULT_CODE_SUCCESS,intent);
//                InputShopItemActivity.this.finish();
//                //Log.e("ahaha","222");
//            }
//        });
//
//        Button buttoncancel=findViewById(R.id.button_cancel);
//        buttoncancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                InputShopItemActivity.this.finish();
//            }
//        });
//    }
//}

package com.jnu.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputShopItemActivity extends AppCompatActivity {

    public static final int RESULT_CODE_SUCCESS = 666;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_shop_item);

        position= this.getIntent().getIntExtra("position",0);
        String title=this.getIntent().getStringExtra("title");
        Double price=this.getIntent().getDoubleExtra("price",0);

        EditText editTextTitle=findViewById(R.id.edittext_shop_item_title);
        EditText editTextPrice=findViewById(R.id.edittext_shop_item_price);
        TextView book_old_title=findViewById(R.id.book_old_name);
        if(null!=title)
        {
            book_old_title.setText("change: "+title);
            editTextTitle.setText(title);
            editTextPrice.setText(price.toString());
        }


        Button buttonOk=findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("title",editTextTitle.getText().toString());
                double price=Double.parseDouble( editTextPrice.getText().toString());
                bundle.putDouble("price",price);
                bundle.putInt("position",position);

                intent.putExtras(bundle);
                setResult(RESULT_CODE_SUCCESS,intent);
                InputShopItemActivity.this.finish();
            }
        });

        Button buttoncancel=findViewById(R.id.button_cancel);
        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputShopItemActivity.this.finish();
            }
        });
    }
}