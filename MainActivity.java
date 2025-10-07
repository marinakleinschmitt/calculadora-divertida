package com.example.calculadoraconta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etConta, etDinheiro;
    Button btnCalcular;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etConta = findViewById(R.id.etConta);
        etDinheiro = findViewById(R.id.etDinheiro);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularConta();
            }
        });
    }

    private void calcularConta() {
        // Pega os valores digitados
        double conta = Double.parseDouble(etConta.getText().toString());
        double dinheiro = Double.parseDouble(etDinheiro.getText().toString());

        // Calcula a taxa (15%)
        double taxa = conta * 0.15;

        // Total com taxa
        double total = conta + taxa;

        // Troco
        double troco = dinheiro - total;

        // Exibe o resultado
        String resultado = "Valor da conta: R$ " + String.format("%.2f", conta) +
                "\nTaxa de serviço (15%): R$ " + String.format("%.2f", taxa) +
                "\nTotal a pagar: R$ " + String.format("%.2f", total) +
                "\nDinheiro entregue: R$ " + String.format("%.2f", dinheiro) +
                "\nTroco: R$ " + String.format("%.2f", troco);

        tvResultado.setText(resultado);
    }
}
