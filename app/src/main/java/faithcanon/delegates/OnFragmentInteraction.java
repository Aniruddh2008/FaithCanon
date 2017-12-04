package faithcanon.delegates;

import android.os.Bundle;
import android.view.View;

import faithcanon.utils.Fragments;


/**
 * Created by A123G4YY on 10/25/2017.
 */

public interface OnFragmentInteraction {

    void onInteraction(Fragments fragments, View v, Bundle bundle);

    void headerTitleUpdate(String title);

    void updateHeaderForSearch();

    void resetHeader();

    void showProgressBar();

    void dismissProgressBar();

    void openSearchKeyboard();

    void hideShowSaveDraftButton(boolean isDraft);
}
