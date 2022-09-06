package com.example.burutoapp.presentation.homescreen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Space
import androidx.compose.animation.core.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.burutoapp.presentation.theme.*

@Composable
fun ShimmerEffect() {

}

@Composable
fun AnimatedShimmerItem() {
    val transition = rememberInfiniteTransition()
    val alphaAnim by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    ShimmerItem(alpha = alphaAnim)
}
@Composable
fun ShimmerItem(alpha: Float) {
   Surface(
       modifier = Modifier
           .fillMaxWidth()
           .height(HERO_ITEM_HEIGHT),
       color = if (isSystemInDarkTheme())
           Color.Black else shimmerLightGray,
       shape = RoundedCornerShape(LARGE_PADDING)
   ) {
       Column(
           modifier = Modifier
               .padding(all = MEDIUM_PADDING),
           verticalArrangement = Arrangement.Bottom
       ){
           Surface(
               modifier = Modifier
                   .fillMaxWidth(0.5f)
                   .height(SHIMMER_HEIGHT)
                   .alpha(alpha = alpha),
               color = if (isSystemInDarkTheme())
                   shimmerDarkGray else shimmerMediumGray,
               shape = RoundedCornerShape(size = SMALL_PADDING)
           ){}
           Spacer(modifier = Modifier.padding(SMALL_PADDING))
           repeat(3){
               Surface(
                   modifier = Modifier
                       .fillMaxWidth()
                       .alpha(alpha = alpha)
                       .height(ABOUT_PLACE_HOLDER),
                   color = if (isSystemInDarkTheme())
                       shimmerDarkGray else shimmerMediumGray,
                   shape = RoundedCornerShape(size = SMALL_PADDING)
               ){}
               Spacer(modifier = Modifier.padding(EXTRA_SMALL_PADDING))
           }
           Row(modifier = Modifier.fillMaxWidth()){
               repeat(5){
                   Surface(
                       modifier = Modifier
                           .size(PLACE_HOLDER_STAR_SHIMMER_EFFECT)
                           .alpha(alpha = alpha),
                       color = if (isSystemInDarkTheme())
                           shimmerDarkGray else shimmerMediumGray,
                       shape = RoundedCornerShape(size = SMALL_PADDING)
                   ){}
                   Spacer(modifier = Modifier.padding(SMALL_PADDING))
               }
           }
       }
    }
}


@Preview
@Composable
fun ShimmerItemPreview() {
    AnimatedShimmerItem()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerItemPreview2() {
    AnimatedShimmerItem()
}





















