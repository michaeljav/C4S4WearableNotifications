package com.exampleandroiddemottest.petagramrecyclerviewWear.presentador;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.exampleandroiddemottest.petagramrecyclerviewWear.db.ConstructorPets;
import com.exampleandroiddemottest.petagramrecyclerviewWear.fragment.IFragment_DetallePets;
import com.exampleandroiddemottest.petagramrecyclerviewWear.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresentadorPetDetalles extends AppCompatActivity
        implements  IRecyclerViewFragmentPresenter{
    private Context mContext;
    private IFragment_DetallePets mIFragment_detallePets;
    private ConstructorPets mConstructorPets;
    private ArrayList<Mascota> mPets;
    private CircularImageView mCircularImagenView;


    public RecyclerViewFragmentPresentadorPetDetalles(IFragment_DetallePets iFragment_DetallePets, Context context,CircularImageView circularImag ) {
        mContext = context;
        mCircularImagenView = circularImag;
        mIFragment_detallePets = iFragment_DetallePets;
        obtenerPetsBaseDatos();
    }

    @Override
    public void obtenerPetsBaseDatos() {
        mConstructorPets = new ConstructorPets(mContext);

        mPets = mConstructorPets.obtenerDatos();
        mostrarPetsRecyclerView();

    }

    @Override
    public void obtenerMediosRecientes() {

    }

    @Override
    public void mostrarPetsRecyclerView() {
        mIFragment_detallePets.inicializarOSetAdapterAlRecyclerView(mIFragment_detallePets.crearAdaptador(mPets));
        mIFragment_detallePets.generarLinearLayoutGrid();
        mIFragment_detallePets.imagenCircular(mCircularImagenView);
    }
}
