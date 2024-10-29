package com.example.futbol_connection;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



      /*  Button changeToMenuInicial = findViewById(R.id.b_loginToMenuInicio);
        changeToMenuInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this,  MenuInicioActivity.class));
            }
        });*/

    }



    public void loginFromFirebase_DB(View view){

        FirebaseFirestore database = FirebaseFirestore.getInstance();

        TextView nombreUsuarioL = findViewById(R.id.txtNombreL);
        TextView passwUsuarioL = findViewById(R.id.txtPasswL);

        String nombre = nombreUsuarioL.getText().toString();
        String passw = passwUsuarioL.getText().toString();

        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(passw)) {
            Toast.makeText(this, "Debes Rellenar Ambos Campos", Toast.LENGTH_SHORT).show();
            return;
        }

        database.collection("usuarios").whereEqualTo("usu_nombre",nombre).whereEqualTo("usu_passw",passw).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && !task.getResult().isEmpty()){
                        Toast.makeText(this, "Inicio de Sesión Exitoso", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(LoginActivity.this, MenuInicioActivity.class));
                        Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(this, "Inicio de Sesión Fallido", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(e -> {
                    Toast.makeText(this, "No se pudo conectar con la base de datos", Toast.LENGTH_SHORT).show();

                });


    }













}