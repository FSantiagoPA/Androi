package com.parrarivera.tema04.ejerciciopaises;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CountryAdapter extends ArrayAdapter<Country> {
    private final Country[] countries;
    private final Context context;

    public CountryAdapter(@NonNull Context context, Country [] countries){
        super(context,R.layout.list_paises,countries);
        this.countries = countries;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View item = convertView;
        ViewHolder holder;

        if (item == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.list_paises, null);

            holder = new ViewHolder();
            holder.nombre = (TextView) item.findViewById(R.id.txtCountry);
            holder.capital = (TextView) item.findViewById(R.id.txtCapital);
            holder.poblacion = (TextView) item.findViewById(R.id.txtNumPoblation);
            holder.imagen = (ImageView) item.findViewById(R.id.imgCountry);
            item.setTag(holder);
        }
        else {
            holder = (ViewHolder) item.getTag();
        }

        holder.nombre.setText(countries[position].getNombre());
        holder.capital.setText(countries[position].getCapital());
        holder.poblacion.setText(countries[position].getPoblacion());
        int imagenId = context.getResources().getIdentifier("_" + countries[position].getCodigo().toLowerCase()
                ,"drawable",context.getOpPackageName());

        if (imagenId != 0){
            holder.imagen.setImageResource(imagenId);
        }

        return item;
    }
}
