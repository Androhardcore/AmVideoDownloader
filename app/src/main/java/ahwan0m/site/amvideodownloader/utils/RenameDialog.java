/*
 *     LM videodownloader is a browser app for android, made to easily
 *     download videos.
 *     Copyright (C) 2018 Loremar Marabillas
 *
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License along
 *     with this program; if not, write to the Free Software Foundation, Inc.,
 *     51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package ahwan0m.site.amvideodownloader.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by loremar on 3/20/18.
 */

public abstract class RenameDialog implements DialogInterface.OnClickListener {
    private EditText text;
    private Context context;

    protected RenameDialog(Context context, String hint) {
        this.context = context;
        text = new EditText(context);
        text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        text.setHint(hint);
        new AlertDialog.Builder(context)
                .setView(text).setMessage("Type new name:")
                .setPositiveButton("OK", this)
                .setNegativeButton("CANCEL", this)
                .create()
                .show();
    }

    @Override
    public final void onClick(DialogInterface dialog, int which) {
        Utils.hideSoftKeyboard((Activity) context, text.getWindowToken());
        if (which == DialogInterface.BUTTON_POSITIVE) {
            onOK(text.getText().toString());
        }
    }

    public abstract void onOK(String newName);
}
