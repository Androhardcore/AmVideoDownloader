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

package ahwan0m.site.amvideodownloader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import ahwan0m.site.amvideodownloader.bookmarks_feature.Bookmarks;
import ahwan0m.site.amvideodownloader.browsing_feature.BrowserManager;
import ahwan0m.site.amvideodownloader.download_feature.fragments.Downloads;
import ahwan0m.site.amvideodownloader.history_feature.History;
import ahwan0m.site.amvideodownloader.utils.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class AMdwActivity extends Activity implements TextView.OnEditorActionListener, View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText webBox;
    private BrowserManager browserManager;
    private Uri appLinkData;
    private CardView cardView;
    private DrawerLayout layout;
    private AdView mAdView;
    private RewardedVideoAd mRewardedVideoAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);
        // Contoh AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-9613697010222085~4950930851");
        mAdView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        webBox = findViewById(R.id.web);
        webBox.setOnEditorActionListener(this);
        ImageButton go = findViewById(R.id.go);
        go.setOnClickListener(this);


        cardView = findViewById(R.id.yutub);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("youtube.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });
        cardView = findViewById(R.id.fbook);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("facebook.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });
        cardView = findViewById(R.id.ig);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("instagram.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });
        cardView = findViewById(R.id.youku);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("youku.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });

        cardView = findViewById(R.id.dailym);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("https://www.dailymotion.com/id");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });

        cardView = findViewById(R.id.twit);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("twitter.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });

        cardView = findViewById(R.id.tumblr);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("tumblr.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });

        cardView = findViewById(R.id.meta);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("metacafe.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });

        cardView = findViewById(R.id.veoh);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("veoh.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });

        cardView = findViewById(R.id.fc2);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("fc2.org");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });

        cardView = findViewById(R.id.space);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("myspace.com");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });

        cardView = findViewById(R.id.vine);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBox = findViewById(R.id.web);
                webBox.setText("vine.co");
                ImageButton go = findViewById(R.id.go);
                go.callOnClick();

            }
        });


        if ((browserManager = (BrowserManager) getFragmentManager().findFragmentByTag("BM")) == null) {
            getFragmentManager().beginTransaction().add(browserManager = new BrowserManager(),
                    "BM").commit();

        }

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        //String appLinkAction = appLinkIntent.getAction();
        appLinkData = appLinkIntent.getData();

        layout = findViewById(R.id.drawer);
        ImageView menu = findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.openDrawer(Gravity.START);
            }
        });

        ListView listView = findViewById(R.id.menu);
        String[] menuItems = new String[]{"Home", "Browser", "Downloads", "Bookmarks",
                "History", "About"};
        ArrayAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout
                .simple_list_item_1, menuItems) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);

        Switch adBlockerSwitch = findViewById(R.id.adBlockerSwitch);
        final SharedPreferences prefs = getSharedPreferences("settings", 0);
        boolean adBlockOn = prefs.getBoolean(getString(R.string.adBlockON), true);
        adBlockerSwitch.setChecked(adBlockOn);
        adBlockerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prefs.edit().putBoolean(getString(R.string.adBlockON), isChecked).apply();
            }
        });

        RecyclerView videoSites = findViewById(R.id.homeSites);
        videoSites.setAdapter(new VideoStreamingSitesList(this));
        videoSites.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        new WebConnect(webBox, this).connect();
        return false;
    }

    @Override
    public void onBackPressed() {
        Fragment sourcePage = getFragmentManager().findFragmentByTag("updateSourcePage");
        if (sourcePage != null) {
            getFragmentManager().beginTransaction().remove(sourcePage).commit();
        } else if (layout.isDrawerVisible(Gravity.START)) {
            layout.closeDrawer(Gravity.START);
        } else if (AMdwApp.getInstance().getOnBackPressedListener() != null) {
            AMdwApp.getInstance().getOnBackPressedListener().onBackpressed();
        } else super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        if (getCurrentFocus() != null) {
            Utils.hideSoftKeyboard(this, getCurrentFocus().getWindowToken());
            new WebConnect(webBox, this).connect();
        }
    }

    private void closeDownloads() {
        Fragment fragment = getFragmentManager().findFragmentByTag("Downloads");
        if (fragment != null) {
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    private void closeBookmarks() {
        Fragment fragment = getFragmentManager().findFragmentByTag("Bookmarks");
        if (fragment != null) {
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    private void closeHistory() {
        Fragment fragment = getFragmentManager().findFragmentByTag("History");
        if (fragment != null) {
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    private void homeClicked() {
        browserManager.hideCurrentWindow();
        closeDownloads();
        closeBookmarks();
        closeHistory();
        setOnBackPressedListener(null);
    }

    public void browserClicked() {
        browserManager.unhideCurrentWindow();
        closeDownloads();
        closeBookmarks();
        closeHistory();
    }

    private void downloadsClicked() {
        closeBookmarks();
        closeHistory();
        if (getFragmentManager().findFragmentByTag("Downloads") == null) {
            browserManager.hideCurrentWindow();
            getFragmentManager().beginTransaction().add(R.id.main, new Downloads(),
                    "Downloads").commit();
        }
    }

    private void bookmarksClicked() {
        closeDownloads();
        closeHistory();
        if (getFragmentManager().findFragmentByTag("Bookmarks") == null) {
            browserManager.hideCurrentWindow();
            getFragmentManager().beginTransaction().add(R.id.main, new Bookmarks(), "Bookmarks")
                    .commit();
        }
    }
    private void historyClicked() {
        closeDownloads();
        closeBookmarks();
        if (getFragmentManager().findFragmentByTag("History") == null) {
                browserManager.hideCurrentWindow();
            getFragmentManager().beginTransaction().add(R.id.main, new History(), "History")
                    .commit();
        }
    }

    private void aboutClicked() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.about, ((ViewGroup) this.getWindow().getDecorView()), false);
        new AlertDialog.Builder(this)
                .setView(v)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        layout.closeDrawers();
        switch (position) {
            case 0:
                homeClicked();
                break;
            case 1:
                browserClicked();
                break;
            case 2:
                downloadsClicked();
                break;
            case 3:
                bookmarksClicked();
                break;
            case 4:
                historyClicked();
                break;
            case 5:
                aboutClicked();
                break;
        }
    }

    public interface OnBackPressedListener {
        void onBackpressed();
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        AMdwApp.getInstance().setOnBackPressedListener(onBackPressedListener);
    }

    public BrowserManager getBrowserManager() {
        return browserManager;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (appLinkData != null) {
            browserManager.newWindow(appLinkData.toString());
        }
        browserManager.updateAdFilters();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        onRequestPermissionsResultCallback.onRequestPermissionsResult(requestCode, permissions,
                grantResults);
    }

    private ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback;

    public void setOnRequestPermissionsResultListener(ActivityCompat
                                                              .OnRequestPermissionsResultCallback
                                                       onRequestPermissionsResultCallback) {
        this.onRequestPermissionsResultCallback = onRequestPermissionsResultCallback;
    }

}
