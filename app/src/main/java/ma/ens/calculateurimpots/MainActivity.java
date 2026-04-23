package ma.ens.calculateurimpots;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText champNom, champAdresse, champSurface, champPieces;
    private CheckBox casePiscine;
    private Button boutonCalcul;
    private TextView zoneResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiserVues();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("habitationAndroid");
        }
        boutonCalcul.setOnClickListener(view -> effectuerCalcul());

    }

    private void initialiserVues() {
        champNom = findViewById(R.id.etNom);
        champAdresse = findViewById(R.id.etAdresse);
        champSurface = findViewById(R.id.etSurfaceMaison);
        champPieces = findViewById(R.id.etNbPieces);
        casePiscine = findViewById(R.id.cbPiscine);
        boutonCalcul = findViewById(R.id.btnCalculerTaxe);
        zoneResultat = findViewById(R.id.tvAffichageResultat);
    }

    private void effectuerCalcul() {
        String surfaceTexte = champSurface.getText().toString().trim();
        String piecesTexte = champPieces.getText().toString().trim();

        if (surfaceTexte.isEmpty() || piecesTexte.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir la surface et le nombre de pièces.", Toast.LENGTH_SHORT).show();
            return;
        }

        double surfaceMaison;
        int nombrePieces;

        try {
            surfaceMaison = Double.parseDouble(surfaceTexte);
            nombrePieces = Integer.parseInt(piecesTexte);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Veuillez saisir des valeurs numériques valides.", Toast.LENGTH_SHORT).show();
            return;
        }

        double taxeBase = calculerTaxeBase(surfaceMaison);
        double taxeSupplementaire = calculerTaxeSupplementaire(nombrePieces, casePiscine.isChecked());
        double taxeTotale = taxeBase + taxeSupplementaire;

        String message = String.format(
                "Montant de base : %.2f DH\nSupplément habitation : %.2f DH\nTotal à payer : %.2f DH",
                taxeBase, taxeSupplementaire, taxeTotale
        );
        zoneResultat.setText(message);
    }

    private double calculerTaxeBase(double surface) {
        return surface * 2;
    }

    private double calculerTaxeSupplementaire(int pieces, boolean piscineExiste) {
        double montantPieces = pieces * 50;
        double montantPiscine = piscineExiste ? 100 : 0;
        return montantPieces + montantPiscine;
    }
}