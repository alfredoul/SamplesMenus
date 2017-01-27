package mx.alfredoul.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // aqui registramos la acción sobre el elemento para el menú de contexto
        TextView tvNombre = (TextView) findViewById(R.id.tvNombrePersona);
        registerForContextMenu(tvNombre);
    }

    ////////////////////////////////////////////////// aqui va el menu opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mMenu:
                ////////////////////////////////////////////////// aqui va el menu sandwich  integrado como actionview en la appbar
                break;
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.mSettings:
                Intent i = new Intent(this, ActivitySettings.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //////////////////////////////////////////////////aqui va el menu contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mEdit:
                //Intent
                Toast.makeText(this, getResources().getString(R.string.menu_edit_toast), Toast.LENGTH_SHORT).show();
                break;
            case R.id.mDelete:
                //Intent
                Toast.makeText(this, getResources().getString(R.string.menu_delete_toast), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //////////////////////////////////////////////////aqui va el menú popup
    //creamos el método que reaccionara al onclick del xml
    public void levantarMenuPopup(View v){
        ImageView share = (ImageView) findViewById(R.id.ivShare);
        PopupMenu popupMenu = new PopupMenu(this, share);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new  PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mFacebook:
                        //Intent
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_facebook_toast), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mWhatsapp:
                        //Intent
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_Wathsapp_toast), Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        popupMenu.show();
    }

}
