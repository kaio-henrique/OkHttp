package br.com.geq.ggti.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import br.com.geq.ggti.okhttp.handler.OkHttp;

/**
 * Created by 750371415 on 15/09/2017.
 */

public class PostActivity extends AppCompatActivity {

    TextView outpuut;
    Button btnSend;
    EditText etName, etPass;
    final String url = "http://serviceapi.skholingua.com/open-feeds/display_received_params.php";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_activity);

        outpuut = (TextView) findViewById(R.id.tvPost);
        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText) findViewById(R.id.etPass);
        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etName.getText().toString();
                String pass = etPass.getText().toString();

                OkHttp handler = new OkHttp(username,pass);

                String result = null;

                try{
                    result = handler.execute(url).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                outpuut.append(result + "n");
            }
        });
    }

}
