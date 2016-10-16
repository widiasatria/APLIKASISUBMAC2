package id.sch.smktelkom_mlg.tugas01.xiirpl3036.aplikasisubmac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nama, nis;
    Spinner kelas;
    //RadioButton laki, pr;
    RadioGroup rgJK;
    CheckBox akustik, dance, teater;
    Button signin;
    TextView nama1, nis1, kelas1, jk1, bidang1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama = (EditText) findViewById(R.id.editTextnama);
        nis = (EditText) findViewById(R.id.editTextnis);
        kelas = (Spinner) findViewById(R.id.spinnerkelas);
        /*laki = (RadioButton) findViewById(R.id.radioButtonlk);
        pr = (RadioButton) findViewById (R.id.radioButtonpr);*/
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        akustik = (CheckBox) findViewById(R.id.checkBoxakus);
        dance = (CheckBox) findViewById(R.id.checkBoxdance);
        teater = (CheckBox) findViewById(R.id.checkBoxteater);
        signin = (Button) findViewById(R.id.buttonsignin);
        nama1 = (TextView) findViewById(R.id.textViewnama1);
        nis1 = (TextView) findViewById(R.id.textViewnis1);
        kelas1 = (TextView) findViewById(R.id.textViewkelas1);
        jk1 = (TextView) findViewById(R.id.textView1jk1);
        bidang1 = (TextView) findViewById(R.id.textViewbidang1);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String Onama1 = nama.getText().toString();
            nama1.setText("Nama Anda: " + Onama1);
            String Onis1 = nis.getText().toString();
            nis1.setText("Nis Anda: " + Onis1);
            kelas1.setText("Kelas Anda: " + kelas.getSelectedItem().toString());
            String bidang = "Bidang Anda:\n";
            String jk = null;
            int startlen = bidang.length();

            if (rgJK.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgJK.getCheckedRadioButtonId());
                jk = rb.getText().toString();
            }

            /*if (laki.isChecked()) {
                kelasanggota = laki.getText().toString();
            } else if (pr.isChecked()) {
                kelasanggota = pr.getText().toString();
            }*/

            if (jk == null) {
                jk1.setText("Anda belum memilih jenis kelamin");
            } else {
                jk1.setText("Jenis kelamin: " + jk);
            }
            if (akustik.isChecked()) bidang += akustik.getText() + "\n";
            if (dance.isChecked()) bidang += dance.getText() + "\n";
            if (teater.isChecked()) bidang += teater.getText() + "\n";
            if (bidang.length() == startlen) bidang += "anda belum memilih";
            bidang1.setText(bidang);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String namasalah = nama.getText().toString();
        String nissalah = nis.getText().toString();


        if (namasalah.isEmpty()) {
            nama.setError("nama belum diisi");
        } else {
            nama.setError(null);
        }

        if (nissalah.isEmpty()) {
            nis.setError("nis belum diisi");
        } else {
            nis.setError(null);
        }


        return valid;
    }

}
