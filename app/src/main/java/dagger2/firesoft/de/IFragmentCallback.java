package dagger2.firesoft.de;

import android.support.v4.app.Fragment;

/**
 * Ermöglicht den Fragmenten einen Fragmentwechsel anzustoßen
 */
public interface IFragmentCallback {

    void switchFragment(int fragmentId);

}
