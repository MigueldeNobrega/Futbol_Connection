package com.example.futbol_connection;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

public void registrarToFirebase_DB(View view) {
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    Map<String, Object> values = new HashMap<>();

    TextView nombreUsuario = findViewById(R.id.txtNombreR);
    TextView correoUsuario = findViewById(R.id.txtCorreoR);
    TextView passwUsuario = findViewById(R.id.txtPasswR);
    TextView passwUsuario2 = findViewById(R.id.txtPassw2R);

    String pass1 = passwUsuario.getText().toString();
    String pass2 = passwUsuario2.getText().toString();
    String nombre = nombreUsuario.getText().toString();
    String correo = correoUsuario.getText().toString();

    // Verificar si las contraseñas coinciden
    if (pass1.equals(pass2)) {
        // Verificar que no haya campos vacíos
        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(correo) || TextUtils.isEmpty(pass1)) {
            Toast.makeText(this, "No puedes dejar campos vacíos", Toast.LENGTH_LONG).show();
            return;
        }

        // Agregar datos al mapa
        values.put("usu_nombre", nombre);
        values.put("usu_correo", correo);
        values.put("usu_passw", pass1);

        // Usar `add` en lugar de `set` para que Firebase Firestore genere un ID automáticamente
        database.collection("usuarios").add(values)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(RegistroActivity.this, "Usuario registrado con ID: " + documentReference.getId(), Toast.LENGTH_LONG).show();



                        startActivity(new Intent(RegistroActivity.this, MenuInicioActivity.class));
                    Toast.makeText(RegistroActivity.this, "Bienvenido", Toast.LENGTH_LONG).show();




                })
                .addOnFailureListener(e -> {
                    Toast.makeText(RegistroActivity.this, "Error. No se pudo registrar", Toast.LENGTH_LONG).show();
                });
    } else {
        Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
    }
}










}