package com.ronak.deliciousbaking.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.ronak.deliciousbaking.R;
import com.ronak.deliciousbaking.models.Steps;
import com.squareup.picasso.Picasso;

public class StepFragment extends Fragment {

    public static final String STEP_DATA = "STEP_DATA";
    public static final String FULLSCREEN_VIDEO = "FULLSCREEN_VIDEO";
    public static final String  VIDEO_POSITION_KEY = "VIDEO_POSITION_KEY";
    public static final String  VIDEO_PLAYING_KEY = "VIDEO_PLAYING_KEY";

    private String videoURL = null;
    private PlayerView simpleExoPlayerView = null;
    private SimpleExoPlayer simpleExoPlayer = null;
    private long videoPos = C.INDEX_UNSET;
    private boolean ready = true;
    private  String thumbnailURL = null;
    private ImageView imageView = null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.step_fragment,container,false);
        final Bundle args = getArguments();
        final Steps steps = args.getParcelable(STEP_DATA);
        videoURL = steps.getVideoURL();
        thumbnailURL = steps.getThumbnailURL();
        if (null != videoURL && !videoURL.isEmpty()){
            simpleExoPlayerView = rootView.findViewById(R.id.step_video_exo);
            if (null != savedInstanceState && savedInstanceState.containsKey(VIDEO_POSITION_KEY) &&
                    savedInstanceState.containsKey(VIDEO_PLAYING_KEY)){
                videoPos = savedInstanceState.getLong(VIDEO_POSITION_KEY);
                ready = savedInstanceState.getBoolean(VIDEO_PLAYING_KEY);
            }

            showVideoView();
            startVideoPlayer();

            if (args.getBoolean(FULLSCREEN_VIDEO, false)){
                simpleExoPlayerView.post(new Runnable(){

                    @Override
                    public void run() {
                        simpleExoPlayerView.getLayoutParams().height = rootView.getLayoutParams().height;
                        simpleExoPlayerView.requestLayout();
                    }
                });
            }
        } else if (null != thumbnailURL && !thumbnailURL.isEmpty()) {
            imageView = rootView.findViewById(R.id.step_visualization);
            showImageView();
            Picasso.get().load(Uri.parse(thumbnailURL)).into(imageView);
        } else {
            hideViews();
        }

        final TextView description = rootView.findViewById(R.id.stepDescription);
        description.setText(steps.getDescription());
        return rootView;

    }

    @Override
    public void onStart() {
        super.onStart();
        startVideoPlayer();
    }

    @Override
    public void onResume() {
        super.onResume();
        startVideoPlayer();
    }

    @Override
    public void onPause() {
        super.onPause();
        releaseVideoPlayer();
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseVideoPlayer();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releaseVideoPlayer();

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(VIDEO_POSITION_KEY, videoPos);
        outState.putBoolean(VIDEO_PLAYING_KEY, ready);
    }

    private void startVideoPlayer(){
        if (null  == simpleExoPlayer && null != videoURL && null != simpleExoPlayerView) {
            final BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            final TrackSelection.Factory trackSelection = new AdaptiveTrackSelection.Factory(bandwidthMeter);
            final TrackSelector trackSelector = new DefaultTrackSelector(trackSelection);
            final Context context = getContext();
            simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(context, trackSelector);
            simpleExoPlayerView.setPlayer(simpleExoPlayer);


            final DataSource.Factory sourceFactory = new DefaultDataSourceFactory(context, com.google.android.exoplayer2.util.Util.getUserAgent(context, getString(R.string.app_name)));
            final ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            final  Uri uri = Uri.parse(videoURL);
            final MediaSource mediaSource = new ExtractorMediaSource(uri,sourceFactory,extractorsFactory,null,null);
            simpleExoPlayer.prepare(mediaSource);
            simpleExoPlayer.setPlayWhenReady(ready);
            simpleExoPlayer.seekTo(videoPos);
            simpleExoPlayerView.requestFocus();
            }
        }

        private void releaseVideoPlayer() {
            if (null != simpleExoPlayerView) {
                simpleExoPlayerView.setPlayer(null);
            }

            if (null != simpleExoPlayer) {
                videoPos = simpleExoPlayer.getCurrentPosition();
                ready = simpleExoPlayer.getPlayWhenReady();
                simpleExoPlayer.release();
                ;
                simpleExoPlayer = null;
            }

        }

    private void hideViews(){

        if (null != simpleExoPlayerView){
            simpleExoPlayerView.setVisibility(View.GONE);
        }
        if (null != imageView){
            imageView.setVisibility(View.GONE);
        }
    }

         private void showVideoView(){
            hideViews();

            if (null != simpleExoPlayerView){
                simpleExoPlayerView.setVisibility(View.VISIBLE);
            }
    }

    private void showImageView(){
        hideViews();
        if (null != imageView){
            imageView.setVisibility(View.VISIBLE);
        }
    }


}
