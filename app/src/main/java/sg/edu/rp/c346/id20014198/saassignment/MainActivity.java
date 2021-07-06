package sg.edu.rp.c346.id20014198.saassignment;

//I, MUHAMMAD RAUL B YASID, declare that:
        //•	This submission is my original work – all sources have been properly referenced and acknowledged.
        //•	I have not copied the words or graphics or ideas or codes from another person/source and submitted it as my own.
        //•	I neither received nor rendered any assistance (either paid or unpaid) on work that requires individual effort.
        //•	I have not communicated, discussed, shared or made available my work with other students, in part or in whole, formally or informally. By doing so, I am also guilty of plagiarism and cheating.

        //If found guilty of committing any act of academic dishonesty, I understand that I will be liable:
        //•	for disciplinary action by the School
        //•	to the full extent of penalties, including immediate failure for this assessment and other disciplinary actions such as dismissal


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvweb;
    Button btnList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        tvweb = findViewById(R.id.tvWeb);
        btnList = findViewById(R.id.btnList);


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ItemListActivity.class);

                startActivity(i);

            }
        });


        tvweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/aulyzd"));
                startActivity(i);
            }
        });
    }
}