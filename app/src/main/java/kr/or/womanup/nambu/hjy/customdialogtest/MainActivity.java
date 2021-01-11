package kr.or.womanup.nambu.hjy.customdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("커스텀 타이틀");
                builder.setIcon(R.mipmap.ic_launcher_round);
                LayoutInflater inflater = getLayoutInflater();
                //방법1
//                View customView = inflater.inflate(R.layout.dialog_custom,null);
//                builder.setView(customView);
                //방법2. 레이아웃 바로 집어 넣기
                builder.setView(R.layout.dialog_custom);
                DialogListener listener = new DialogListener();
                builder.setPositiveButton("로그인",listener);
                builder.setNeutralButton("취소",listener);
                builder.show();
            }
        });
    }

    class DialogListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which!=AlertDialog.BUTTON_POSITIVE){return;}
            AlertDialog alert = (AlertDialog) dialog;
            EditText edtId = alert.findViewById(R.id.edt_id);
            EditText edtPass = alert.findViewById(R.id.edt_pass);
            String userId = edtId.getText().toString(); //editable 타입이라 toString필요
            String pass = edtPass.getText().toString();
            textView.setText("ID : "+userId+"\npassword: "+pass);

/*            switch (which){
                case AlertDialog.BUTTON_POSITIVE:
                    textView.setText("ID : "+userId+"\npassword: "+pass); break;
                case  AlertDialog.BUTTON_NEUTRAL:
                    textView.setText("취소"); break;
            }*/
        }
    }

}