package com.edu.gdmec.s07150825.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hasee on 2016/10/8.
 */
public class Alert_Dialog extends Activity {

    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
        tView= (TextView) this.findViewById(R.id.textViewa1);
        Button btn1= (Button) this.findViewById(R.id.buttona1);
        Button btn2= (Button) this.findViewById(R.id.buttona2);
        Button btn3= (Button) this.findViewById(R.id.buttona3);
        Button btn4= (Button) this.findViewById(R.id.buttona4);
        Button btn5= (Button) this.findViewById(R.id.buttona5);
        Button btn6= (Button) this.findViewById(R.id.buttona6);
        Button btn7= (Button) this.findViewById(R.id.buttona7);
        View.OnClickListener listener=new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.buttona1:
                        dialog1();
                        break;
                    case R.id.buttona2:
                        dialog2();
                        break;
                    case R.id.buttona3:
                        dialog3();
                        break;
                    case R.id.buttona4:
                        dialog4();
                        break;
                    case R.id.buttona5:
                        dialog5();
                        break;
                    case R.id.buttona6:
                        dialog6();
                        break;
                    case R.id.buttona7:
                        dialog7();
                        break;
                }
            }

        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);

    }

    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    Alert_Dialog.this.finish();
                }else if (which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }

    public void dialog2() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="程序猿";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="自由职业者";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="度假屋";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"程序猿",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"自由职业者",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"度假屋",listener);
        dialog.show();
    }

    public void dialog3(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit=new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    public void dialog4(){

        final String item[]=new String[]{"北京烤鸭","上海小吃","广州春卷"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListenter= new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListenter);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了";
                for (int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();

    }

    public void dialog5(){

        final String item[]=new String[]{"北京烤鸭","上海小吃","广州春卷"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<bSelect.length;i++){
                    bSelect[i]=false;
                    if(bSelect[i]==bSelect[which]){
                        bSelect[which]=true;
                    }

                }
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,listener);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for (int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=item[i];

                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener1);
        dialog.show();
    }

    public void dialog6(){

        final String item[]=new String[]{"北京烤鸭","上海小吃","广州春卷"};
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了："+item[which];
                tView.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,listener);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener1);
        dialog.show();
    }

    public void dialog7(){

        LayoutInflater inflaster =getLayoutInflater();
        View layout =inflaster.inflate(R.layout.alert_dialog_1,null);
        final EditText tEdit= (EditText) layout.findViewById(R.id.editText1);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();

    }

}
