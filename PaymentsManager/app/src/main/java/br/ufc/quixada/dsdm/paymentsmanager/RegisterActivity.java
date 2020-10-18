package br.ufc.quixada.dsdm.paymentsmanager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    private Button btnPhoto;
    private ImageView imagePhoto;
    private EditText textName;
    private EditText textEmail;
    private EditText textPassword;
    private EditText textConfirmPassword;
    private Button btnRegister;
    private TextView textViewLogin;

    private Uri selectedUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnPhoto = findViewById(R.id.registerBtnSelectPhoto);
        imagePhoto = findViewById(R.id.registerImgVwPhoto);
        textName = findViewById(R.id.registerEdtName);
        textEmail = findViewById(R.id.registerEdtEmail);
        textPassword = findViewById(R.id.registerEdtPassword);
        textConfirmPassword = findViewById(R.id.registerEdtConfirmPassword);
        btnRegister = findViewById(R.id.registerBtnRegister);
        textViewLogin = findViewById(R.id.registerTextLinkLogin);

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPhoto();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            selectedUri = data.getData();

            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedUri);
                imagePhoto.setImageDrawable(new BitmapDrawable(bitmap));
                btnPhoto.setAlpha(0);
            } catch (IOException e) {
                Log.i("Error", "Imagem nao carregou");
                e.printStackTrace();
            }

        }
    }

    private void selectPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    private void createUser() {
        String name = textName.getText().toString().trim();
        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();
        String confirmPassword = textConfirmPassword.getText().toString().trim();

        if (name.isEmpty() || name == null
                || email.isEmpty() || email.equals("")
                || password.isEmpty() || password.equals("")
                || confirmPassword.isEmpty() || confirmPassword.equals("")) {
            Toast toast = Toast.makeText(this, R.string.errorWrongFields, Toast.LENGTH_SHORT);
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast toast = Toast.makeText(this, R.string.errorIncompatiblePasswords, Toast.LENGTH_SHORT);
            return;
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.i("Task:", task.getResult().getUser().getUid());
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Error", e.getMessage());
                    }
                });
    }
}
