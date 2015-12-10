package com.artifex.mupdfdemo.mupdf;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.RelativeLayout;

import com.artifex.mupdfdemo.FilePicker;
import com.artifex.mupdfdemo.MuPDFCore;
import com.artifex.mupdfdemo.MuPDFPageAdapter;
import com.artifex.mupdfdemo.MuPDFReaderView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity {
    /*
     *ButterKnife Controls
     */
    @Bind(R.id.content_view)
    RelativeLayout mContentView;

    private MuPDFCore core;
    private MuPDFReaderView mDocView;
    private String mFilePath;
    Bundle args = new Bundle();
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        try {
            InputStream ins = getResources().getAssets().open("MuPdf.pdf");
            FileOutputStream fos = new FileOutputStream(new File(getExternalCacheDir()+"/1.pdf"));
            byte[] b = new byte[1024];
            while(ins.read(b)!= -1){
                fos.write(b);
            }
            fos.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Uri uri = Uri.parse(getExternalCacheDir()+"/1.pdf");
        core = openFile(uri.getPath());
        if (core != null && core.countPages() == 0) {
            core = null;
        }
        if (core == null || core.countPages() == 0 || core.countPages() == -1) {
            Log.e(TAG, "Document Not Opening");
        }
        if (core != null) {
            mDocView = new MuPDFReaderView(this) {
                @Override
                protected void onMoveToChild(int i) {
                    if (core == null)
                        return;
                    super.onMoveToChild(i);
                }

            };
            mDocView.setAdapter(new MuPDFPageAdapter(this, new FilePicker.FilePickerSupport() {
                @Override
                public void performPickFor(FilePicker picker) {

                }
            }, core));
            mContentView.addView(mDocView);
//            View v = new View(this);
//
//            v.setBackgroundColor(Color.RED);
//            mContentView.addView(v);
        }
    }

    @Override
    public void onDestroy() {
        if (core != null)
            core.onDestroy();
        core = null;
        super.onDestroy();
    }

    private MuPDFCore openFile(String path) {
        int lastSlashPos = path.lastIndexOf('/');
        mFilePath = new String(lastSlashPos == -1
                ? path
                : path.substring(lastSlashPos + 1));
        try {
            core = new MuPDFCore(this, path);
            // New file: drop the old outline data
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
        return core;
    }
}
