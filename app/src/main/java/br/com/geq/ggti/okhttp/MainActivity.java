package br.com.geq.ggti.okhttp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.geq.ggti.okhttp.handler.OkHttpHandler;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnPost;
    ImageView imgView;
    TextView tv;
    private final String url = "http://serviceapi.skholingua.com/images/skholingua_image.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView) findViewById(R.id.imgView);
        tv = (TextView) findViewById(R.id.tvBytes);
        btnStart = (Button) findViewById(R.id.btnPost);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpHandler handler = new OkHttpHandler();

                byte[] img = new byte[0];
                try {
                    img = handler.execute(url).get();
                    if(img != null && img.length > 0){
                        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                        imgView.setImageBitmap(bitmap);
                        tv.setText("Total Bytes download: " + img.length);
                    }
                }catch (Exception e){
                    tv.setText("Sorry, something went wrong!");
                }
            }
        });

        btnPost = (Button) findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PostActivity.class));
            }
        });
    }
}
