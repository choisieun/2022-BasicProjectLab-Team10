package kr.ac.cnu.computer.googlemaptest;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.*;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ActivityForBusB extends AppCompatActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback
{
    private GoogleMap map;

    private static final String TAG = "googlemap_example";
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int UPDATE_INTERVAL_MS = 1000;
    private static final int FATEST_UPDATE_INTERVAL_MS = 500;

    private static final int PERMISSIONS_REQUEST_CODE = 100;
    boolean needRequest = false;

    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    Location mCurrentLocation;
    LatLng currentPosition;

    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest locationRequest;
    private Location location;
    boolean isSetCurrentLocation = false;

    private View mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_bus_b);

        locationRequest = new LocationRequest()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL_MS)
                .setFastestInterval(FATEST_UPDATE_INTERVAL_MS);

        LocationSettingsRequest.Builder builder =
                new LocationSettingsRequest.Builder();

        builder.addLocationRequest(locationRequest);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ImageButton moveToCNU = findViewById(R.id.moveToCNU);
        moveToCNU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefaultLocation();
            }
        });

        ImageButton switchToAButton = findViewById(R.id.switchToA);
        switchToAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityForBusB.this, ActivityForBusA.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Log.d(TAG, "onMapReady");

        map = googleMap;

        LatLng numberOne = new LatLng(36.36393623045683, 127.34512288367394);
        LatLng numberTwo = new LatLng(36.36714486295813, 127.34252209519627);
        LatLng numberThree = new LatLng(36.36928319643853, 127.3412887661673);
        LatLng numberFour = new LatLng(36.37432282798491, 127.34388914314896);
        LatLng numberFive = new LatLng(36.37642789094089, 127.34416989166898);
        LatLng numberSix = new LatLng(36.37191266851502, 127.34303753992411);
        LatLng numberSeven = new LatLng(36.370497971570686, 127.34378814811502);
        LatLng numberEight = new LatLng(36.36948527558873, 127.34637197830905);
        LatLng numberNine = new LatLng(36.36905242935213, 127.35195036061559);
        LatLng numberTen = new LatLng(36.36718432295817, 127.3520528560284);
        LatLng numberEleven = new LatLng(36.369165630679575, 127.35198915694087);
        LatLng numberTwelve = new LatLng(36.37234435419047, 127.34648149906977);
        LatLng numberThirteen = new LatLng(36.36942310420768, 127.34612949247371);
        LatLng numberFourteen = new LatLng(36.3673418, 127.3455367);
        LatLng numberFifteen = new LatLng(36.365987855484114, 127.3453100226298);

//????????? ?????? : ?????? ?????? ?????? ????????? ?????? ??????
        LatLng librery = new LatLng(36.369316, 127.345914);

        LatLng east_of_lib_1_intersection1= new LatLng(36.36978364, 127.34713638);

        //????????? ?????? ?????????
        LatLng east_of_lib_2_northofInt1= new LatLng(36.37124332, 127.34732369);
        LatLng east_of_lib_3_northofInt2= new LatLng(36.37142844,127.34732399);
        LatLng east_of_lib_4_northofInt3= new LatLng(36.37157123,127.34723114);
        LatLng north_of_lib= new LatLng(36.37275383,127.34604556);


        //5 6 7 ????????? ??????
        LatLng east_of_lib_6= new LatLng(36.36995399,127.34767012);
        LatLng east_of_lib_7= new LatLng(36.37019933,127.34800274);
        LatLng east_of_lib_8= new LatLng(36.37056608,127.34825481);
        LatLng east_of_lib_9= new LatLng(36.3706499,127.34842395);
        LatLng east_of_lib_10= new LatLng(36.37062608,127.34868098);
        LatLng east_of_lib_11= new LatLng(36.37053807,127.34882131);
        LatLng east_of_lib_12= new LatLng(36.36915108,127.34961868);
        LatLng east_of_lib_13= new LatLng(36.36902125,127.34968559);
        LatLng east_of_lib_14= new LatLng(36.36893412,127.34983338);
        LatLng east_of_lib_15= new LatLng(36.36891032,127.35002309);
        LatLng east_of_lib_16= new LatLng(36.36898677,127.3501816);
        LatLng east_of_lib_17= new LatLng(36.36911151,127.35035572);
        LatLng east_of_lib_18= new LatLng(36.36927499,127.35063115);
        LatLng east_of_lib_19= new LatLng(36.36940493,127.35085204);
        LatLng east_of_lib_20= new LatLng(36.36944893,127.35094559);
        LatLng east_of_lib_21= new LatLng(36.3694859,127.35098716);
        LatLng east_of_lib_22= new LatLng(36.36946077,127.35117682);

        LatLng east_of_lib_intersection_to_6and7= new LatLng(36.36883054,127.35235855);

        LatLng east_of_lib_24= new LatLng(36.36872541,127.35229934);
        LatLng east_of_lib_25= new LatLng(36.36894547,127.35245851);
        LatLng east_of_lib_26= new LatLng(36.36921879,127.35189782);
        LatLng east_of_lib_27= new LatLng(36.36911765,127.35183482);

        //????????? ???????????? ?????? ???????????? ??????
        LatLng west_of_lib_1= new LatLng(36.37038209,127.34423234);
        LatLng west_of_lib_2= new LatLng(36.37047777,127.3431969);

        LatLng west_of_lib_intersection= new LatLng(36.37043426,127.34291101);

        //?????? ?????? ?????? ??????
        LatLng west_of_lib_3= new LatLng(36.36984855,127.34101124);
        LatLng west_of_lib_4= new LatLng(36.36888636,127.34152086);
        LatLng west_of_lib_5= new LatLng(36.36783805,127.34147325);
        LatLng west_of_lib_6= new LatLng(36.36616327,127.34396786);

        //????????? ??????
        LatLng west_of_lib_7 = new LatLng(36.37137671,127.34289062);
        LatLng west_of_lib_8= new LatLng(36.37594242,127.34441761);
        LatLng west_of_lib_9= new LatLng(36.37612673,127.34443543);
        LatLng west_of_lib_10= new LatLng(36.37629159,127.34443011);
        LatLng west_of_lib_11= new LatLng(36.3763821,127.34433875);

        MarkerOptions stationOne = new MarkerOptions();
        stationOne.position(numberOne)
                .title("??????????????????????????????");

        MarkerOptions stationTwo = new MarkerOptions();
        stationTwo.position(numberTwo)
                .title("???????????????????????????(??????????????????)");

        MarkerOptions stationThree = new MarkerOptions();
        stationThree.position(numberThree)
                .title("?????????(????????????????????????)");

        MarkerOptions stationFour = new MarkerOptions();
        stationFour.position(numberFour)
                .title("?????????2?????????");

        MarkerOptions stationFive = new MarkerOptions();
        stationFive.position(numberFive)
                .title("?????????????????????????????????(??????)");

        MarkerOptions stationSix = new MarkerOptions();
        stationSix.position(numberSix)
                .title("??????????????????");

        MarkerOptions stationSeven = new MarkerOptions();
        stationSeven.position(numberSeven)
                .title("??????????????????");

        MarkerOptions stationEight = new MarkerOptions();
        stationEight.position(numberEight)
                .title("???????????????(???????????????????????????)");

        MarkerOptions stationNine = new MarkerOptions();
        stationNine.position(numberNine)
                .title("??????????????????????????? ???");

        MarkerOptions stationTen = new MarkerOptions();
        stationTen.position(numberTen)
                .title("??????????????????");

        MarkerOptions stationEleven = new MarkerOptions();
        stationEleven.position(numberEleven)
                .title("??????????????????????????????");

        MarkerOptions stationTwelve = new MarkerOptions();
        stationTwelve.position(numberTwelve)
                .title("??????????????????3??????");

        MarkerOptions stationThirteen = new MarkerOptions();
        stationThirteen.position(numberThirteen)
                .title("???????????????(?????????????????? ??????)");

        MarkerOptions stationFourteen = new MarkerOptions();
        stationFourteen.position(numberFourteen)
                .title("??????????????????");

        MarkerOptions stationFifteen = new MarkerOptions();
        stationFifteen.position(numberFifteen)
                .title("??????????????????????????????");

        BitmapDrawable bitmapDrawStationOne = (BitmapDrawable) getResources().getDrawable(R.drawable.first_station);
        Bitmap b1 = bitmapDrawStationOne.getBitmap();
        stationOne.icon(BitmapDescriptorFactory.fromBitmap(b1));

        BitmapDrawable bitmapDrawStationTwo = (BitmapDrawable) getResources().getDrawable(R.drawable.second_station);
        Bitmap b2 = bitmapDrawStationTwo.getBitmap();
        stationTwo.icon(BitmapDescriptorFactory.fromBitmap(b2));

        BitmapDrawable bitmapDrawStationThree = (BitmapDrawable) getResources().getDrawable(R.drawable.third_station);
        Bitmap b3 = bitmapDrawStationThree.getBitmap();
        stationThree.icon(BitmapDescriptorFactory.fromBitmap(b3));

        BitmapDrawable bitmapDrawStationFour = (BitmapDrawable) getResources().getDrawable(R.drawable.fourth_station);
        Bitmap b4 = bitmapDrawStationFour.getBitmap();
        stationFour.icon(BitmapDescriptorFactory.fromBitmap(b4));

        BitmapDrawable bitmapDrawStationFive = (BitmapDrawable) getResources().getDrawable(R.drawable.fifth_station);
        Bitmap b5 = bitmapDrawStationFive.getBitmap();
        stationFive.icon(BitmapDescriptorFactory.fromBitmap(b5));

        BitmapDrawable bitmapDrawStationSix = (BitmapDrawable) getResources().getDrawable(R.drawable.sixth_station);
        Bitmap b6 = bitmapDrawStationSix.getBitmap();
        stationSix.icon(BitmapDescriptorFactory.fromBitmap(b6));

        BitmapDrawable bitmapDrawStationSeven = (BitmapDrawable) getResources().getDrawable(R.drawable.seventh_station);
        Bitmap b7 = bitmapDrawStationSeven.getBitmap();
        stationSeven.icon(BitmapDescriptorFactory.fromBitmap(b7));

        BitmapDrawable bitmapDrawStationEight = (BitmapDrawable) getResources().getDrawable(R.drawable.eighth_station);
        Bitmap b8 = bitmapDrawStationEight.getBitmap();
        stationEight.icon(BitmapDescriptorFactory.fromBitmap(b8));

        BitmapDrawable bitmapDrawStationNine = (BitmapDrawable) getResources().getDrawable(R.drawable.ninth_station);
        Bitmap b9 = bitmapDrawStationNine.getBitmap();
        stationNine.icon(BitmapDescriptorFactory.fromBitmap(b9));

        BitmapDrawable bitmapDrawStationTen = (BitmapDrawable) getResources().getDrawable(R.drawable.tenth_station);
        Bitmap b10 = bitmapDrawStationTen.getBitmap();
        stationTen.icon(BitmapDescriptorFactory.fromBitmap(b10));

        BitmapDrawable bitmapDrawStationEleven = (BitmapDrawable) getResources().getDrawable(R.drawable.eleventh_station);
        Bitmap b11 = bitmapDrawStationEleven.getBitmap();
        stationEleven.icon(BitmapDescriptorFactory.fromBitmap(b11));

        BitmapDrawable bitmapDrawStationTwelve = (BitmapDrawable) getResources().getDrawable(R.drawable.twelfth_station);
        Bitmap b12 = bitmapDrawStationTwelve.getBitmap();
        stationTwelve.icon(BitmapDescriptorFactory.fromBitmap(b12));

        BitmapDrawable bitmapDrawStationThirteen = (BitmapDrawable) getResources().getDrawable(R.drawable.thirteenth_station);
        Bitmap b13 = bitmapDrawStationThirteen.getBitmap();
        stationThirteen.icon(BitmapDescriptorFactory.fromBitmap(b13));

        BitmapDrawable bitmapDrawStationFourteen = (BitmapDrawable) getResources().getDrawable(R.drawable.fourteenth_station);
        Bitmap b14 = bitmapDrawStationFourteen.getBitmap();
        stationFourteen.icon(BitmapDescriptorFactory.fromBitmap(b14));

        BitmapDrawable bitmapDrawStationFifteen = (BitmapDrawable) getResources().getDrawable(R.drawable.fifteenth_station);
        Bitmap b15 = bitmapDrawStationFifteen.getBitmap();
        stationFifteen.icon(BitmapDescriptorFactory.fromBitmap(b15));

        // ????????? ?????? polyline ?????? ?????? ( ?????? ????????? ???????????? ????????? ???????????? ?????? ???????????? ?????? ?????? )
        PolylineOptions polylineOptions1 = new PolylineOptions()
                .add(new LatLng(36.36393623045683, 127.34512288367394),new LatLng(36.36739570866662, 127.34560855449526)
                        ,new LatLng(36.369316, 127.345914) ,new LatLng(36.36948527558873, 127.34637197830905),new LatLng(36.36978364, 127.34713638)
                        ,new LatLng(36.37121358, 127.34734004),new LatLng(36.37142844,127.34732399),new LatLng(36.37157123,127.34723114)
                        ,new LatLng(36.37234435419047, 127.34648149906977),new LatLng(36.37275383,127.34604556))
                .color(Color.BLUE)
                .geodesic(true);

        PolylineOptions polylineOptions2 = new PolylineOptions()
                .add(new LatLng(36.369316, 127.345914), new LatLng(36.37038209,127.34423234),new LatLng(36.370497971570686, 127.34378814811502)
                        ,new LatLng(36.37047777,127.3431969),new LatLng(36.37040177,127.34292932),new LatLng(36.36984855,127.34101124)
                        ,new LatLng(36.36888636,127.34152086),new LatLng(36.36783805,127.34147325),new LatLng(36.36714486295813, 127.34252209519627)
                        ,new LatLng(36.36616327,127.34396786),new LatLng(36.365987855484114, 127.3453100226298))
                .color(Color.BLUE)
                .geodesic(true);
        //????????? ??????(???????????? ????????? ?????? ??? ??????!)
        PolylineOptions polylineOptions3 = new PolylineOptions()
                .add(new LatLng(36.37039270,127.34291101),new LatLng(36.37137671,127.34289062),new LatLng(36.37191266851502, 127.34303753992411)
                        ,new LatLng(36.37432282798491, 127.34388914314896),new LatLng(36.37594242,127.34439761),new LatLng(36.37612673,127.34443543)
                        ,new LatLng(36.37629159,127.34443011),new LatLng(36.3763821,127.34433875),new LatLng(36.37642789094089, 127.34416989166898))
                .color(Color.BLUE)
                .geodesic(true);
        // 5 6 7 ??? ??????
        PolylineOptions polylineOptions4 = new PolylineOptions()
                .add(new LatLng(36.36978364, 127.34713638),new LatLng(36.36995399,127.34767012),new LatLng(36.37019933,127.34800274)
                        ,new LatLng(36.37056608,127.34825481),new LatLng(36.3706499,127.34842395),new LatLng(36.37062608,127.34868098)
                        ,new LatLng(36.37053807,127.34882131),new LatLng(36.36915108,127.34961868),new LatLng(36.36902125,127.34968559)
                        ,new LatLng(36.36893412,127.34983338),new LatLng(36.36891032,127.35002309),new LatLng(36.36898677,127.3501816)
                        ,new LatLng(36.36911151,127.35035572),new LatLng(36.36927499,127.35063115),new LatLng(36.36940493,127.35085204)
                        ,new LatLng(36.36944893,127.35094559),new LatLng(36.3694799,127.35098716),new LatLng(36.36948077,127.35117682)
                        ,new LatLng(36.36905242935213, 127.35195036061559),new LatLng(36.36883054,127.35235855),new LatLng(36.36872541,127.35229934)
                        ,new LatLng(36.36718432295817, 127.3520528560284))
                .color(Color.BLUE)
                .geodesic(true);
        PolylineOptions polylineOptions5 = new PolylineOptions()
                .add(new LatLng(36.36883054,127.35235855),new LatLng(36.36894547,127.35245851),new LatLng(36.369165630679575, 127.35198915694087)
                        ,new LatLng(36.36921879,127.35189782),new LatLng(36.36911765,127.35183482))
                .color(Color.BLUE)
                .geodesic(true);

        Polyline polyline1 = map.addPolyline(polylineOptions1);
        polyline1.setJointType(JointType.ROUND);

        Polyline polyline2 = map.addPolyline(polylineOptions2);
        polyline2.setJointType(JointType.ROUND);

        Polyline polyline3 = map.addPolyline(polylineOptions3);
        polyline3.setJointType(JointType.ROUND);

        Polyline polyline4 = map.addPolyline(polylineOptions4);
        polyline4.setJointType(JointType.ROUND);

        Polyline polyline5 = map.addPolyline(polylineOptions5);
        polyline5.setJointType(JointType.ROUND);

        map.addMarker(stationOne);
        map.addMarker(stationTwo);
        map.addMarker(stationThree);
        map.addMarker(stationFour);
        map.addMarker(stationFive);
        map.addMarker(stationSix);
        map.addMarker(stationSeven);
        map.addMarker(stationEight);
        map.addMarker(stationNine);
        map.addMarker(stationTen);
        map.addMarker(stationEleven);
        map.addMarker(stationTwelve);
        map.addMarker(stationThirteen);
        map.addMarker(stationFourteen);
        map.addMarker(stationFifteen);

        setDefaultLocation();

        int hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {
            startLocationUpdates();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {
                Snackbar.make(mLayout, "??? ?????? ??????????????? ?????? ?????? ????????? ???????????????.",
                        Snackbar.LENGTH_INDEFINITE).setAction("??????", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ActivityCompat.requestPermissions(ActivityForBusB.this, REQUIRED_PERMISSIONS,
                                PERMISSIONS_REQUEST_CODE);
                    }
                }).show();
            } else {
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }
        }

        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Log.d(TAG, "onMapClick");
            }
        });

    }

    LocationCallback locationCallback = new LocationCallback() {
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);

            List<Location> locationList = locationResult.getLocations();

            if (locationList.size() > 0) {
                location = locationList.get(locationList.size() - 1);

                currentPosition = new LatLng(location.getLatitude(), location.getLatitude());
                if (!isSetCurrentLocation) {
                    setCurrentLocation(location);
                    isSetCurrentLocation = true;
                }
                mCurrentLocation = location;
            }
        }
    };

    private void startLocationUpdates() {

        if (!checkLocationServicesStatus()) {
            Log.d(TAG, "startLocaionUpdates : call showDialogForLocationServiceSetting");
            showDialogForLocationServiceSetting();
        } else {
            int hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION);
            int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION);

            if (hasFineLocationPermission != PackageManager.PERMISSION_GRANTED ||
                    hasCoarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "startLocationUpdates : ????????? ??? ????????? ??????");
                return;
            }

            Log.d(TAG, "startLocationUpdates : call mFusedLocationClient.requestLocationUpdates");

            mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());

            if (checkPermission()) {
                map.setMyLocationEnabled(true);
            }


        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");

        isSetCurrentLocation = false;
        if (checkPermission()) {

            Log.d(TAG, "onStart : call mFusedLocationClient.requestLocationUpdates");
            mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);

            if (map!=null)
                map.setMyLocationEnabled(true);

        }


    }


    @Override
    protected void onStop() {

        super.onStop();

        if (mFusedLocationClient != null) {

            Log.d(TAG, "onStop : call stopLocationUpdates");
            mFusedLocationClient.removeLocationUpdates(locationCallback);
        }
    }


    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


    public void setCurrentLocation(Location location) { // ?????? ????????? ??? ?????? ????????? ????????? ???????????? ???
        LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(currentLatLng);
        map.moveCamera(cameraUpdate);
    }


    public void setDefaultLocation() {

        LatLng DEFAULT_LOCATION = new LatLng(36.369067172679344, 127.346911313043);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION, 15);
        map.moveCamera(cameraUpdate);

    }


    //??????????????? ????????? ????????? ????????? ?????? ????????????
    private boolean checkPermission() {

        int hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);



        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED   ) {
            return true;
        }

        return false;

    }



    /*
     * ActivityCompat.requestPermissions??? ????????? ????????? ????????? ????????? ???????????? ??????????????????.
     */
    @Override
    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {

        super.onRequestPermissionsResult(permsRequestCode, permissions, grandResults);
        if (permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            // ?????? ????????? PERMISSIONS_REQUEST_CODE ??????, ????????? ????????? ???????????? ??????????????????

            boolean check_result = true;


            // ?????? ???????????? ??????????????? ???????????????.

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }


            if (check_result) {

                // ???????????? ??????????????? ?????? ??????????????? ???????????????.
                startLocationUpdates();
            } else {
                // ????????? ???????????? ????????? ?????? ????????? ??? ?????? ????????? ??????????????? ?????? ???????????????.2 ?????? ????????? ????????????.

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])) {


                    // ???????????? ????????? ????????? ???????????? ?????? ?????? ???????????? ????????? ???????????? ?????? ????????? ??? ????????????.
                    Snackbar.make(mLayout, "???????????? ?????????????????????. ?????? ?????? ???????????? ???????????? ??????????????????. ",
                            Snackbar.LENGTH_INDEFINITE).setAction("??????", new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            finish();
                        }
                    }).show();

                } else {


                    // "?????? ?????? ??????"??? ???????????? ???????????? ????????? ????????? ???????????? ??????(??? ??????)?????? ???????????? ???????????? ?????? ????????? ??? ????????????.
                    Snackbar.make(mLayout, "???????????? ?????????????????????. ??????(??? ??????)?????? ???????????? ???????????? ?????????. ",
                            Snackbar.LENGTH_INDEFINITE).setAction("??????", new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            finish();
                        }
                    }).show();
                }
            }

        }
    }


    //??????????????? GPS ???????????? ?????? ????????????
    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityForBusB.this);
        builder.setTitle("?????? ????????? ????????????");
        builder.setMessage("?????? ???????????? ???????????? ?????? ???????????? ???????????????.\n"
                + "?????? ????????? ???????????????????");
        builder.setCancelable(true);
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case GPS_ENABLE_REQUEST_CODE:

                //???????????? GPS ?????? ???????????? ??????
                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {

                        Log.d(TAG, "onActivityResult : GPS ????????? ?????????");


                        needRequest = true;

                        return;
                    }
                }

                break;
        }
    }
}
