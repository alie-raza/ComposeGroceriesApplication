package com.alidev.groceriesapplication.presentation.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alidev.groceriesapplication.R
import com.alidev.groceriesapplication.ui.theme.DIMENS_12dp
import com.alidev.groceriesapplication.ui.theme.DIMENS_16dp
import com.alidev.groceriesapplication.ui.theme.DIMENS_40dp
import com.alidev.groceriesapplication.ui.theme.DIMENS_68dp
import com.alidev.groceriesapplication.ui.theme.DIMENS_90dp
import com.alidev.groceriesapplication.ui.theme.GilroyFontFamily
import com.alidev.groceriesapplication.ui.theme.GrayTextColor
import com.alidev.groceriesapplication.ui.theme.Green
import com.alidev.groceriesapplication.ui.theme.TEXT_SIZE_16sp
import com.alidev.groceriesapplication.ui.theme.TEXT_SIZE_18sp
import com.alidev.groceriesapplication.ui.theme.TEXT_SIZE_49sp

fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {


}

@Composable
fun onBoarding(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_onboarding),
            contentDescription = stringResource(R.string.image_on_boarding),
            contentScale = ContentScale.Crop,
        )
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = DIMENS_90dp),
            color = Color.Transparent
        ) {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = stringResource(R.string.welcome_to_store),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_49sp,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = stringResource(R.string.desc_welcome),
                    color = GrayTextColor,
                    fontWeight = FontWeight.Medium,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_16sp,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(DIMENS_40dp))
                Button(
                    onClick = {
                        onClick.invoke()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = DIMENS_68dp)
                        .padding(start = DIMENS_16dp, end = DIMENS_16dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                    shape = RoundedCornerShape(DIMENS_12dp),
                ) {
                    Text(
                        text = stringResource(R.string.get_started),
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = TEXT_SIZE_18sp,
                        color = Color.White
                    )
                }





            }



        }
    }



}

@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    onBoarding(
        onClick = {}
    )
}

