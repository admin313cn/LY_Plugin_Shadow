//package cn.u313.plugin;
//
//import static cn.u313.music.utils.tool.Config.notice;
//import static cn.u313.music.utils.tool.Config.str;
//import static cn.u313.music.utils.tool.Tool.setNotice0;
//
//import android.Manifest;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.content.pm.PackageManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.google.gson.Gson;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import cn.u313.music.BuildConfig;
//import cn.u313.music.R;
//import cn.u313.music.constants.DialogOncilk;
//import cn.u313.music.http.HttpCallback;
//import cn.u313.music.http.HttpClient;
//import cn.u313.music.http.Setting;
//import cn.u313.music.model.AuConfig;
//import cn.u313.music.model.Data;
//import cn.u313.music.model.GxConfig;
//import cn.u313.music.model.InitConfig;
//import cn.u313.music.model.ThemeFile;
//import cn.u313.music.storage.FristApp;
//import cn.u313.music.storage.preference.Preferences;
//import cn.u313.music.utils.Base64Utils;
//import cn.u313.music.utils.DownloadUtil;
//import cn.u313.music.utils.FileUtils;
//import cn.u313.music.utils.GetManager;
//import cn.u313.music.utils.SharedPreferencesUtils;
//import cn.u313.music.utils.YLog;
//import cn.u313.music.utils.impl.UpdateApp;
//import cn.u313.music.utils.interfacer.GxFastRunApp;
//import cn.u313.music.utils.t;
//import cn.u313.music.widget.DIYDialog;
//import cn.u313.music.widget.DialogLy;
//import cn.u313.music.widget.UserUsrXieYi;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//
//
//public class WelcomeActivity extends BaseActivity {
//    //todo: ?????????
//    public static int varsion = BuildConfig.VERSION_CODE;
//    //????????????
//
//    long sign=0x45122000;
//    private static final String TAG = "WelcomeActivity";
//    private SharedPreferences sharepreferences;
//    private SharedPreferences.Editor editor;
//    private static final int PERMISSON_REQUESTCODE = 1;
//    private ImageView bingIv;
//    public  static  Context context;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_welcome);
//////        int i = 1/0;
////        context=this;
//////        Log.e(TAG, "onCreate: "+
//////                t.stringFromJNI1(getApplicationContext() ));
////
//////        if(true){
//////            YLog.e(t.stringFromJNI0(getApplicationContext()));
//////            return;
//////        }
//////        {
////////            Log.e(TAG, "onCreate?????????: "+ t.stringFromJNI1(getApplicationContext()) );
//////            Config.weburl ="http://139.196.155.40/test.html";
//////            startActivity(new Intent(getApplicationContext(),WebActivity.class));
//////            finish();
//////            return ;
//////        }
//////        Log.e(TAG, "onCreate: " +getSignature(getApplicationContext()));
//////        context = getApplicationContext();
////        context=this;
////        loadBingPic();
////
////
////
////        // TODO: 2021/11/9 ??????app??????
////        FristApp.sign(getApplicationContext(), new UserUsrXieYi() {
////            @Override
////            public void p() {
////                error();
////            }
////            @Override
////            public void g() {
////                error();
////            }
////            @Override
////            public void c() {
////                error();
////            }
////            @Override
////            public void h() {
////                error();
////            }
////
////            @Override
////            public void u() {
////                init();
////            }
////        });
//
//
//    }
//    void error(){
//        new DialogLy(this).sign();
//    }
//
//
//    void init(){
//        bingIv = (ImageView)findViewById(R.id.welcome_bing_iv);
//        loadBingPic();
//        sharepreferences=this.getSharedPreferences("check", MODE_PRIVATE);
//        sharepreferences=this.getSharedPreferences("theme_color", MODE_PRIVATE);
//        editor=sharepreferences.edit();
//        String ps= (String) SharedPreferencesUtils.getParam(this,"splash",
//                "http://y.313u.cn/splash/1589801438168.jpg");
//
//        Glide.with(this).load(ps).into(bingIv);
//
//        initPermission();
//
////        Toast.makeText(context, "??????????????????app", Toast.LENGTH_SHORT).show();
//
//    }
//
//    private void loadBingPic(){
//
//        bingIv = (ImageView)findViewById(R.id.welcome_bing_iv);
//        Glide.with(this).load("http://y.313u.cn/splash/1EB9BA6835F2726901B939A2EBA46D82.jpg").into(bingIv);
//    }
//
//    private void checkSkip() {
//        // TODO: 2021/11/9  app?????????????????????
//        HttpClient.getMeanInit(new HttpCallback<InitConfig>() {
//            @Override
//            public void onSuccess(InitConfig initConfig) {
//                if(initConfig!=null){
//                    Setting.InitConfig=initConfig;
//                    //?????????????????????
//                    //??????app?????????
//                    String filePath = FileUtils.getConfigDir() + "x_user.ly";
//                    try {
//                        FileUtils.saveLrcFile(filePath,
//                                        Base64Utils.base64Encode(
//                                            new Gson().toJson(initConfig).getBytes()));
//                    } catch (Exception e) {
//                        Log.e(TAG, "Exception:x_user ??????????????????" );
//                        Toast.makeText(getApplicationContext(), "Exception: ??????????????????", Toast.LENGTH_SHORT).show();
//                        e.printStackTrace();
//                    }
//                    SharedPreferencesUtils.setParam(getApplicationContext(),"host",initConfig.getMusic2());
//                    SharedPreferencesUtils.setParam(getApplicationContext(),"downloadHead",initConfig.getDownloadHeadF());
//                    SharedPreferencesUtils.setParam(getApplicationContext(),"localhostMusic",initConfig.getLocalhostMusic());
//                    SharedPreferencesUtils.setParam(getApplicationContext(),"submitMusic",initConfig.getSubmitMusic());
//                    SharedPreferencesUtils.setParam(getApplicationContext(),"startMusic",initConfig.getStartMusic());
//                    SharedPreferencesUtils.setParam(getApplicationContext(),"mean",initConfig.isMean());
//                    if(initConfig.isNotice()){
//                        //??????
//                        Toast.makeText(getApplicationContext(), initConfig.getNotice(), Toast.LENGTH_SHORT).show();
//
//                    }
//                    HttpClient.getMusicDownloadConfig(initConfig.getLocalhostMusic(),new HttpCallback<AuConfig>(){
//                        @Override
//                        public void onSuccess(AuConfig configMusic) {
//
//                            String str= new Gson().toJson(configMusic);
//
//                            SharedPreferencesUtils.setParam(getApplicationContext(),"musicConfig",str);
//                            //Toast.makeText(context, "configMusic>"+configMusic.getAuthst(), Toast.LENGTH_SHORT).show();
//                            getInit();
//                        }
//
//                        @Override
//                        public void onFail(Exception e) {
//                            Toast.makeText(getApplicationContext(), "????????????????????????", Toast.LENGTH_SHORT).show();
//                        }
//                    });
////                    setDefTheme();
//                    return;
//                }
//
//                getInit();
//            }
//
//            @Override
//            public void onFail(Exception e) {
//                e.printStackTrace();
//                Log.e(TAG, "Exception: ?????????????????????" );
//                getInit();
//                return ;
//            }
//        },varsion);
//
//    }
//
//    /**
//     * ??????app??????
//     */
//    private void getInit(){
//        new Thread(() -> {
//            String a= GetManager.get(getInitConfig().getDns()+"/getConfig?t="+varsion+"&u="+ Math.random()+"&p="+ System.currentTimeMillis());
//            try {
//                Thread.sleep(500);
//                runOnUiThread(() -> {
//                    if(a==null||a.length()<100){
//                        Toast.makeText(this, "????????????????????????????????????????????????", Toast.LENGTH_SHORT).show();
//
//                    }else{
//                        GxConfig gxConfig=new Gson().fromJson(a, GxConfig.class);
//                        GxConfig.DataBean dataBean=gxConfig.getData();
//
//                        //???????????????app
//                        if(!dataBean.isGoin()){
//                            //?????????
//                            new DialogLy(this)
//                                    .setText(dataBean.getNoticeText())
//                                    .gx(false,new UserUsrXieYi() {
//                                        @Override
//                                        public void no() {
//                                            Toast.makeText(getApplicationContext(), "????????????", Toast.LENGTH_SHORT).show();
//                                        }
//
//                                        @Override
//                                        public void yes() {
//                                            Toast.makeText(getApplicationContext(), "????????????", Toast.LENGTH_SHORT).show();
//                                        }
//                                    });
//
//                            return;
//                        }
//
//                        //????????????
//                        if(dataBean.getNoticeId()>(int) SharedPreferencesUtils.getParam(this,"noticeId",0)){
//                            notice=true;
//                            str=dataBean.getNoticeText();
//                            SharedPreferencesUtils.setParam(this,"noticeId",dataBean.getNoticeId());
//                            Log.e(TAG, "checkSkip: "+ SharedPreferencesUtils.getParam(this,"noticeId",0));
//
//                        }else{
//                            // Toast.makeText(this, "??????"+sign, Toast.LENGTH_SHORT).show();
//
//                        }
//
//                        SharedPreferencesUtils.setParam(this,"splash",dataBean.getSplash());
//                        if(dataBean.getGxId()!=0){
//
//                            gx(dataBean.getGxText());
//                        }else{
//                            startMusicActivity();
//                        }
//                        return;
//
//                    }
//
//                    new DIYDialog(this)
//                            .setBtnText("?????????","??????app")
//                            .setTitle("???????????????")
//                            .setText("??????????????????????????????????????????????????????????????????????????????,????????????app??????????????????????????????")
//                            .setClick(new DialogOncilk() {
//                                @Override
//                                public void close() {
//                                    finish();
//                                }
//
//                                @Override
//                                public void ok() {
//                                    startMusicActivity();
//
//                                }
//
//                                @Override
//                                public void Exception(Exception e) {
//
//                                }
//                            }).show();
//
//                });
//            } catch (Exception e) {
//                e.printStackTrace();
//                new DIYDialog(this).setTitle("???????????????").setText("??????????????????????????????????????????????????????????????????????????????,????????????????????????",60).show();
//
//            }
//
//        }).start();
//    }
//    private void gx(String msg){
//        new DialogLy(this).setText(msg).gx(new UserUsrXieYi() {
//            @Override
//            public void no() {
//                //?????????
//                startMusicActivity();
//            }
//
//            @Override
//            public void yes() {
//                //??????
//                Intent intent = new Intent();
//                intent.setClass(getApplicationContext(), AboutActivity.class);
//                startActivity(intent);
//
//                finish();
//            }
//        });
//    }
//    private void startMusicActivity() {
//        UpdateApp.RunApp(getApplicationContext(), varsion, new GxFastRunApp() {
//            @Override
//            public void fast() {
////                new DialogLy(WelcomeActivity.this).isTMBg(false).userUse(new UserUsrXieYi() {
////                    @Override
////                    public void no() {
////
////                        SharedPreferencesUtils.setParam(context,"version",1);
////                        finish();
////                    }
////
////                    @Override
////                    public void yes() {
//                        setNotice0(getApplicationContext());
//                        setDefTheme();
////                    }
////                });
//
//
//
//                //????????????app
//                //Toast.makeText(getContext(), "???????????????", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void gxFast() {
//                Intent intent = new Intent();
//                intent.setClass(getApplicationContext(), MusicActivity.class);
//                startActivity(intent);
//                //overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
//                finish();
//                //Toast.makeText(getContext(), "????????????????????????", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void apply() {
//                Intent intent = new Intent();
//                intent.setClass(getApplicationContext(), MusicActivity.class);
//                startActivity(intent);
//                //overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
//                finish();
//                //Toast.makeText(getContext(), "?????????n???", Toast.LENGTH_SHORT).show();
//            }
//        });
////        //??????????????????????????????
////        FristApp.app0(this, new Appt() {
////            @Override
////            public void frist() {
////
////            }
////
////            @Override
////            public void noFrist() {
////
////
////
////            }
////        });
//    }
//
//
//    /**
//     * ?????????????????????????????????
//     */
//    private void initPermission() {
//        //??????
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
//            checkSkip();
//            return;
//        }
//        //????????????
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//
//            // ?????? ?????? ???????????????
//            ActivityCompat.requestPermissions(this, new String[]{
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
//
//                    Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
//        }
//
//
//        if (ContextCompat.checkSelfPermission(WelcomeActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(WelcomeActivity.this,
//                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                    PERMISSON_REQUESTCODE);
//        }else {
//            checkSkip();
//        }
//    }
//
//    /**
//     * ??????????????????
//     */
//    private void setDefTheme(){
//        buildProgressDialog("???????????????????????????....");
//        new Thread(() -> {
//            saveSettingMsg(Setting.InitConfig.getDefTheme());
//
//        }).start();
//    }
//    public  final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//
//    /**
//     * ????????????
//     * @param k
//     */
//    public void saveSettingMsg(String k) {
//
//        OkHttpClient client=new OkHttpClient();
//        String param= "{\"comm\":{\"key\":0.9969730822633631,\"u\":\"62455" +
//                "5\",\"ct\":0,\"cv\":0,\"authst\":\"aslfajdhlaskdhf" +
//                "jlmdfajd\"},\"param\":{\"mothed\":\"getFileKey\",\"sha" +
//                "reId\":\""+k+"\",\"sign\":\"\"}}";
//        RequestBody requestBody = RequestBody.create(JSON, param);
//        Request request = new Request.Builder()
//                .post(requestBody)
//                .url("http://pan7.313u.cn/cgi-bin/share")
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: ??????");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//                Log.d(TAG, "onResponse: " + result);
//                try {
//                    ThemeFile themeFile=new Gson().fromJson(result, ThemeFile.class);
//                    Data data=themeFile.getData();
//
//
//                    if(themeFile==null||data==null){
//                        runOnUiThread(() -> {
//                            Toast.makeText(context, "??????????????????", Toast.LENGTH_SHORT).show();
//                        });
//                    }else{
//                        downloadTheme(data.getUrl());
//                        runOnUiThread(() -> {
//                            //????????????
//                            Log.e(TAG, "URL: "+ data.getUrl());
//
//                        });
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    runOnUiThread(() -> {
//                        Toast.makeText(context, "?????????????????????"+e.toString(), Toast.LENGTH_SHORT).show();
//                        cancelProgressDialog();
//                    });
//                }
//
//            }
//        });
//
//    }
//    /**
//     * ????????????
//     */
//    public void setThemeAc(){
//        new DIYDialog(WelcomeActivity.this)
//                .setBtnText("?????????","????????????")
//                .setTitle("????????????")
//                .setDialogEv(false)//??????
//                .setEv(false)// ????????????????????????
//                .setText("???????????????????????????????????????????????????app??????????????????????????????????????????????????????????????????????????????????????????",40)
//                .setClick(new DialogOncilk() {
//                    @Override
//                    public void close() {
//                        Preferences.saveQunMianPing(true);
//                        Intent intent = new Intent();
//                        intent.setClass(getApplicationContext(), MusicActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//
//                    @Override
//                    public void ok() {
//
//                        Preferences.saveQunMianPing(false);
//                        Intent intent = new Intent();
//                        intent.setClass(getApplicationContext(), MusicActivity.class);
//                        startActivity(intent);
//                        //overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
//                        finish();
//
//                    }
//
//                    @Override
//                    public void Exception(Exception e) {
//
//                    }
//                }).show();
//    }
//
//    /**
//     * ????????????
//     * @param url
//     */
//    private void downloadTheme(String url){
//
//        DownloadUtil.get(context).download(url, "theme0.zip", new DownloadUtil.OnDownloadListener() {
//            @Override
//            public void onDownloadSuccess() {
//                //??????
//                // Log.i("??????","????????????");
////                    Toast.makeText(context, "????????????", Toast.LENGTH_SHORT).show();
//                //Looper.loop();
//                try {
//                    //??????????????????
//                    FileUtils.unZip("theme0.zip",context.getFilesDir()+"",context);
//                    SharedPreferencesUtils.setParam(context,"themeSetType",true);
////                        musicActivity.finish();
//
//                    runOnUiThread(() -> {
//                        setThemeAc();
//                        Toast.makeText(context, "?????????????????????????????????", Toast.LENGTH_SHORT).show();
//                    });
//                } catch (RuntimeException e) {
//                    finish();
//                    runOnUiThread(() -> Toast.makeText(context, "???????????????"+e.toString(), Toast.LENGTH_SHORT).show());
//                    e.printStackTrace();
//                }
//                cancelProgressDialog();
//            }
//
//
//
//            @Override
//            public void onDownloading(int progress) {
//                //??????
//                Log.i("??????",progress+"%");
//            }
//
//            @Override
//            public void onDownloadFailed() {
//                cancelProgressDialog();
//                //??????
//                Log.i("??????","????????????");
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(context, "????????????", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }
//        });
//    }
//    private ProgressDialog progressDialog;
//    public void buildProgressDialog(String string) {
//        if (progressDialog == null) {
//            progressDialog = new ProgressDialog(context);
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//
//        }
//        progressDialog.setMessage(string);
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//    }
//    /**
//     * @Description: TODO ???????????????
//     * @author Sunday
//     * @date 2015???12???25???
//     */
//    public void cancelProgressDialog() {
//        if (progressDialog !=null )
//            if (progressDialog.isShowing()) {
//                progressDialog.dismiss();
//            }
//
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        Log.e(TAG, "onRequestPermissionsResult:\n requestCode: "+requestCode+"\npermissions:"+ Arrays.toString(permissions)+"\ngrantResults:"+Arrays.toString(grantResults) );
//        if(permissions.length==0){
//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//            return;
//        }
//        if(grantResults.length==0||grantResults[0]==-1){
//            Toast.makeText(getApplicationContext(), "?????????????????????????????????????????????", Toast.LENGTH_SHORT).show();
//            //finish();
//            return;
//        }
//        checkSkip();
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
//
//    public void xiaochengx(View view) {
////        FinAppClient.INSTANCE.getAppletApiManager().startApplet(getApplicationContext(), "6051607a0c2f62000167518c");
//    }
////    @Override
////    public void finish() {
////        new CatDialog(this)
////                .setBtnText("?????????","?????????")
////                .setTitle("??????")
////                .setText("???????????????????????? T.T ?????????")
////                .setClick(new DialogOncilk() {
////                    @Override
////                    public void close() {
////                        Toast.makeText(getApplicationContext(), "???????????????", Toast.LENGTH_SHORT).show();
////                    }
////
////                    @Override
////                    public void ok() {
////                        Toast.makeText(getApplicationContext(), "???????????????", Toast.LENGTH_SHORT).show();
////
////                    }
////
////                    @Override
////                    public void Exception(Exception e) {
////
////                    }
////                }).show();
////    }
//}
