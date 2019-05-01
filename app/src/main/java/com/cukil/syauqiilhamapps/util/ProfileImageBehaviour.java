package com.cukil.syauqiilhamapps.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.cukil.syauqiilhamapps.R;
import com.google.android.material.appbar.AppBarLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import de.hdodenhof.circleimageview.CircleImageView;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class ProfileImageBehaviour extends CoordinatorLayout.Behavior<CircleImageView> {

    private int startXPositionImage;
    private int startYPositionImage;
    private int startHeight;
    private int startToolbarHeight;

    private boolean initialised = false;

    private float amountOfToolbarToMove;
    private float amountOfImageToReduce;
    private float amountToMoveXPosition;
    private float amountToMoveYPosition;

    private float finalToolbarHeight, finalXPosition, finalYPosition, finalHeight;

    public ProfileImageBehaviour(
            final Context context,
            final AttributeSet attrs) {

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ProfileImageBehaviour);
            finalXPosition = a.getDimension(R.styleable.ProfileImageBehaviour_finalXPosition, 0);
            finalYPosition = a.getDimension(R.styleable.ProfileImageBehaviour_finalYPosition, 0);
            finalHeight = a.getDimension(R.styleable.ProfileImageBehaviour_finalHeight, 0);
            finalToolbarHeight = a.getDimension(R.styleable.ProfileImageBehaviour_finalToolbarHeight, 0);
            a.recycle();
        }
    }

    @Override
    public boolean layoutDependsOn(
            final CoordinatorLayout parent,
            final CircleImageView child,
            final View dependency) {

        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(
            final CoordinatorLayout parent,
            final CircleImageView child,
            final View dependency) {

        initProperties(child, dependency);

        float currentToolbarHeight = startToolbarHeight + dependency.getY();
        currentToolbarHeight = currentToolbarHeight < finalToolbarHeight ? finalToolbarHeight : currentToolbarHeight;
        final float amountAlreadyMoved = startToolbarHeight - currentToolbarHeight;
        final float progress = 100 * amountAlreadyMoved / amountOfToolbarToMove;

        final float heightToSubtract = progress * amountOfImageToReduce / 100;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.width = (int) (startHeight - heightToSubtract);
        lp.height = (int) (startHeight - heightToSubtract);
        child.setLayoutParams(lp);

        final float distanceXToSubtract = progress * amountToMoveXPosition / 100;
        final float distanceYToSubtract = progress * amountToMoveYPosition / 100;
        float newXPosition = startXPositionImage - distanceXToSubtract;
        child.setX(newXPosition);
        child.setY(startYPositionImage - distanceYToSubtract);
        return true;
    }

    private void initProperties(
            final CircleImageView child,
            final View dependency) {

        if (!initialised) {
            startHeight = child.getHeight();
            startXPositionImage = (int) child.getX();
            startYPositionImage = (int) child.getY();
            startToolbarHeight = dependency.getHeight();
            amountOfToolbarToMove = startToolbarHeight - finalToolbarHeight;
            amountOfImageToReduce = startHeight - finalHeight;
            amountToMoveXPosition = startXPositionImage - finalXPosition;
            amountToMoveYPosition = startYPositionImage - finalYPosition;
            initialised = true;
        }
    }
}