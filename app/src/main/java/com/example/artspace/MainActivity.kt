package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            ArtSpaceTheme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Projects()
                }
            }
        }
    }
}
//windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
//@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun Projects( modifier: Modifier = Modifier)  {
//    val showTopAppBar = windowSizeClass.windowHeightSizeClass != WindowHeightSizeClass.COMPACT
    var currentStep by remember { mutableIntStateOf(1) }

    val imageResource = when (currentStep) {
        1 -> R.drawable.my_portfolio_sand_seven_72_vercel_app___1_
        2 -> R.drawable.woodyrr_github_io_soleilla_
        3 -> R.drawable.best_takes_vercel_app_
        4 -> R.drawable.recipes_two_opal_vercel_app_home__1_
        else -> R.drawable.my_portfolio_sand_seven_72_vercel_app___1_
    }
    val description = when (currentStep) {
        1 -> R.string.portfolio_desk
        2 -> R.string.e_commerce_desk
        3 -> R.string.best_take_desk
        4 -> R.string.recipes_desk
        else -> R.string.portfolio_desk
    }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 65.dp, horizontal = 10.dp)
        , verticalArrangement = Arrangement.SpaceBetween) {

        Column (modifier = Modifier
            .fillMaxWidth()
        ) {
            Image(painter = painterResource(imageResource), contentDescription = currentStep.toString(),
                modifier
                    .fillMaxWidth()
//                    .weight(1f)
                    .border(
                        BorderStroke(1.dp, Color.Gray),
                        RoundedCornerShape(30.dp)
                    )
                    .clip(RoundedCornerShape(30.dp))

            )
            Spacer(modifier = modifier.padding(10.dp))

            Text(text = stringResource(id = description), modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .align(Alignment.End),

                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
                )

        }




        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.Bottom ) {
            Button(onClick = {
                if (currentStep > 1){
                    currentStep--

                }else{
                    currentStep = 1
                }
            }, modifier,colors = ButtonDefaults.buttonColors(containerColor = Color(155, 235, 206))
            ) {
//                Text(text = "<<")
                Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = currentStep.toString(), modifier = Modifier.width(50.dp)  )
            }
            Spacer(modifier = Modifier.padding(2.dp))


            Button(onClick = {
                if (currentStep < 4){
                    currentStep++

                }else{
                    currentStep = 4
                }
            }, modifier,colors = ButtonDefaults.buttonColors(containerColor = Color(155, 235, 206))) {
//                Text(text = ">>")
                Image(painter = painterResource(id = R.drawable.baseline_arrow_forward_24), contentDescription = currentStep.toString(), modifier = Modifier.width(50.dp) )
            }
        }


    }

//    else{MyScreen(
//        showTopAppBar = showTopAppBar
//        , modifier = Modifier
//    )}



}

//@Composable
//fun MyScreen(showTopAppBar:Boolean, modifier: Modifier){
//    var currentStep by remember { mutableIntStateOf(1) }
//
//    val imageResource = when (currentStep) {
//        1 -> R.drawable.my_portfolio_sand_seven_72_vercel_app___1_
//        2 -> R.drawable.woodyrr_github_io_soleilla_
//        3 -> R.drawable.best_takes_vercel_app_
//        4 -> R.drawable.recipes_two_opal_vercel_app_home__1_
//        else -> R.drawable.my_portfolio_sand_seven_72_vercel_app___1_
//    }
//    val description = when (currentStep) {
//        1 -> R.string.portfolio_desk
//        2 -> R.string.e_commerce_desk
//        3 -> R.string.best_take_desk
//        4 -> R.string.recipes_desk
//        else -> R.string.portfolio_desk
//    }
//    Row(modifier = Modifier
//        .fillMaxSize()
//
//        .padding(vertical = 25.dp, horizontal = 10.dp)
//        , horizontalArrangement = Arrangement.SpaceAround,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Button(onClick = {
//            if (currentStep > 1){
//                currentStep--
//
//            }else{
//                currentStep = 1
//            }
//        }, modifier.align(Alignment.CenterVertically), colors = ButtonDefaults.buttonColors(containerColor = Color(155, 235, 206))
//        ) {
////                Text(text = "<<")
//            Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
//                contentDescription = currentStep.toString(),
//                modifier = Modifier.width(50.dp)  )
//        }
//
//        Column (modifier = Modifier
////            .verticalScroll(rememberScrollState())
//            .fillMaxHeight()
//        ) {
//            Image(painter = painterResource(imageResource), contentDescription = currentStep.toString(),
//                modifier
//                    .fillMaxHeight()
//                    .border(
//                        BorderStroke(1.dp, Color.Gray),
//                        RoundedCornerShape(30.dp)
//                    )
//                    .clip(RoundedCornerShape(30.dp))
//
//            )
//            Spacer(modifier = modifier.padding(10.dp))
//
//            Text(text = stringResource(id = description), modifier
//                .fillMaxHeight()
//                .padding(horizontal = 10.dp)
//                .align(Alignment.End),
//
//                fontSize = 17.sp,
//                textAlign = TextAlign.Center,
//                fontWeight = FontWeight.SemiBold,
//                color = Color.DarkGray
//            )
//
//        }
//
//            Button(onClick = {
//                if (currentStep < 4){
//                    currentStep++
//
//                }else{
//                    currentStep = 4
//                }
//            }, modifier,colors = ButtonDefaults.buttonColors(containerColor = Color(155, 235, 206))) {
//                Image(painter = painterResource(id = R.drawable.baseline_arrow_forward_24), contentDescription = currentStep.toString(), modifier = Modifier.width(50.dp) )
//            }
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Projects()
    }
}