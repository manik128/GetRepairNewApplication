package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.atss.getrepairnewapplication.R;

public class ArticleActivity extends AppCompatActivity {
WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);

        webview=(WebView)findViewById(R.id.webview);
        Intent intent = getIntent();
        String pish = "<html><head><style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/Kontrapunkt-Light.otf\")}body {font-family: MyFont;font-size: medium;text-align: justify;}</style></head><body>";
        String pas = "</body></html>";
        String myvar1=intent.getStringExtra("ques");
        String myvar=intent.getStringExtra("cont");
        String myvar2 ="<html><head><style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/Kontrapunkt-Light.otf\")}body {font-family: MyFont;font-size: medium;text-align: justify;}</style></head><body>"+ "<p><span style=\"Kontrapunkt-Light.otf\"><strong></span>"+myvar1+"</strong></p>"+
                ""+
                "<p> "+myvar+"</span></p>";
//        String myvar = "<p><strong>Bikes:</strong></p>"+
//                ""+
//                "<ul>"+
//                "<li style=\"margin-bottom:9.0pt;\"><strong>How do you Make Your Winter Bike Commute a Safer Trip</strong></li>"+
//                "</ul>"+
//                ""+
//                "<p><span style=\"background:white\">Winter commutes can feel incredibly rewarding. Seeing the sun rise by bike is a luxury a select few enjoy and there’s nothing better than arriving home to a nice warm drink, safe in the knowledge you’re staying fit and saving time whilst the rest of the world takes the train. That, and you’ll avoid the lurgies floating around on public transport (and the traffic congestion caused by all those people who just don’t know how to drive in the rain).</span></p>"+
//                ""+
//                "<p><span style=\"background:white\">So – ready to sign yourself up to the winter commute? Then we’ve got the perfect guide to get you going…</span></p>"+
//                ""+
//                "<ul style=\"list-style-type:circle;\">"+
//                "<li style=\"background:white;\"><strong>Close your eyes and get out that door (then open them)</strong></li>"+
//                "<li style=\"background:white;\">Keep yourself warm and comfy</li>"+
//                "<li style=\"background:white;\"><strong>Stay visible with lights and bright clothing</strong></li>"+
//                "<li style=\"background:white;\">Update your tyres</li>"+
//                "<li style=\"background:white;\">Ride with the conditions in mind</li>"+
//                "</ul>"+
//                ""+
//                "<p> </p>"+
//                ""+
//                "<p> </p>"+
//                ""+
//                "<p> </p>"+
//                ""+
//                "<ul>"+
//                "<li style=\"margin-bottom:9.0pt;\"><strong>What should your next bike be made from? Carbon vs steel vs aluminium vs titanium</strong></li>"+
//                "</ul>"+
//                ""+
//                "<h2 style=\"line-height:13.2pt;background:white;\"> </h2>"+
//                ""+
//                "<p><strong><span style=\"background:white\">Bikes can be made from all sorts of different materials, from less common metals like magnesium all the way down to wood or bamboo.</span></strong></p>"+
//                ""+
//                "<p>But in the current market there are four materials that are by far the most popular: carbon fibre, aluminium, steel and titanium.</p>"+
//                ""+
//                "<p>Ultimately your decision should be made with regard to what you want the bike for. For example,</p>"+
//                ""+
//                "<ul style=\"list-style-type:circle;\">"+
//                "<li style=\"background:white;\">if you’re planning on commuting on it you should be thinking about affordability and durability, and that might knock carbon out of the equation.</li>"+
//                "<li style=\"background:white;\"><span style=\"background:white\">steel was pretty much the only option for a bike frame. Other materials were either in their infancy or yet to be used for framebuilding, and the strength and durability of steel means it’s minimal fuss in maintenance terms.</span></li>"+
//                "<li style=\"background:white;\"><strong><span style=\"background:white\">Aluminium alloys are a very popular choice for bike frames. There are a huge amount of aluminium frames out there and you can pay everything from £400 for a complete bike all the way up to £7,500 if you want something super fancy like Specialized’s S-Works Allez.</span></strong></li>"+
//                "<li style=\"background:white;\"><strong><span style=\"background:white\">The first and most notable drawback with titanium is cost. It’s both an expensive material in itself and requires specialist machinery and skills to work it into a frame, which is why ti bikes aren’t all that common and the ones on the market tend to cost a bit more, particularly when it comes to other metals like steel and aluminium.</span></strong></li>"+
//                "</ul>"+
//                ""+
//                "<p> </p>"+
//                ""+
//                "<ul>"+
//                "<li style=\"margin-bottom:9.0pt;\"><strong>Do you want a forever bike?</strong></li>"+
//                "</ul>"+
//                ""+
//                "<ul style=\"list-style-type:circle;\">"+
//                "<li style=\"margin-top:0cm;margin-right:0cm;margin-bottom:9.0pt;\"><span style=\"background:white\">In our repair shop each year, we see several <strong><span style=\"border:none windowtext 1.0pt; padding:0cm\">expensive</span></strong> bikes each year rendered useless! .</span> That seems unacceptable to me for bikes this expensive, and less than five years old. This is due to the use of proprietary parts, or parts that don not comply with ISO standards.</li>"+
//                "<li style=\"margin-top:0cm;margin-right:0cm;margin-bottom:9.0pt;\"><strong><span style=\"background:white; border:none windowtext 1.0pt; padding:0cm\">Proprietary parts</span></strong> <span style=\"background:white\">are parts designed specifically for use with that particular bike. They are only made by that manufacturer, and they only sell them to dealers that carry that brand of bike.</span></li>"+
//                "<li style=\"margin-top:0cm;margin-right:0cm;margin-bottom:9.0pt;\"><strong><span style=\"background:white; border:none windowtext 1.0pt; padding:0cm\">Part standards that are non-ISO compliant</span></strong> <span style=\"background:white\">are phony ‘standards’ that are really just new designs issued by companies wanting to say that their bikes use standard parts. The difference between proprietary parts and these phony ‘standard’ parts is that they allow anyone to use the new ‘standard’ if they want to….so….somehow that makes it a standard. This is just another way to build</span><a href=\"http://www.rodbikes.com/articles/web_articles/chaos.html\"> <span style=\"background:white; border:none windowtext 1.0pt; padding:0cm\">planned obsolescence</span></a> <span style=\"background:white\">into an expensive bicycle.</span></li>"+
//                "</ul>"+
//                ""+
//                "<p><strong>Cars:</strong></p>"+
//                ""+
//                "<ul>"+
//                "<li style=\"margin-top:0cm;margin-right:0cm;margin-bottom:0cm;margin-bottom:.0001pt;background:white;vertical-align:baseline;\"><a href=\"https://www.globalcarsbrands.com/do-fancy-cars-help-businessmen-make-money/\" title=\"Do Fancy Cars Help Businessmen Make Money?\"><strong><span style=\"border:none windowtext 1.0pt; padding:0cm\">Do Fancy Cars Help Businessmen Make Money?</span></strong></a></li>"+
//                "</ul>"+
//                ""+
//                "<ul style=\"list-style-type:circle;\">"+
//                "<li><span style=\"background:white\">There people who have a lifestyle that attracts money. That’s the perfect life for them. Now, many may believe this is only possible for celebrities, as perhaps we have all seen how models, singers, and actors so easily attract money by flaunting their highly expensive dresses, jewelry, suits, boots, and so on.</span></li>"+
//                "<li><span style=\"background:white\">Nevertheless, if you believe this, you are definitely mistaken. To get that desirability, one must create a lifestyle which attracts people. For instance, how do businessmen manage to attract all those pretty ladies, investors, business contracts and still keep their pockets full? Well, the answer is simple, my friend: their lifestyle attracts money. And one of the factors contributing to that lifestyle is keeping a luxurious car. Yes, it is true: fancy cars do help businessmen make money.</span></li>"+
//                "<li><span style=\"background:white\">Here is a post about how an </span><a href=\"http://www.quicksprout.com/2014/12/15/how-a-ferrari-made-me-a-million-bucks/\" target=\"_blank\"><span style=\"background:white; border:none windowtext 1.0pt; padding:0cm\">internet marketer Neil Patel made a million bucks with a Ferrari</span></a><span style=\"background:white\">. There you go, that shows how different businessmen have used cars and an extravagant lifestyle to attract high paying business.</span></li>"+
//                "</ul>"+
//                ""+
//                "<ul>"+
//                "<li style=\"margin-top:0cm;margin-right:0cm;margin-bottom:0cm;margin-bottom:.0001pt;background:white;vertical-align:baseline;\"><a href=\"https://www.globalcarsbrands.com/driverless-cars/\" title=\"All You Need To Know About Driverless Cars\"><strong><span style=\"border:none windowtext 1.0pt; padding:0cm\">All You Need To Know About Driverless Cars</span></strong></a></li>"+
//                "</ul>"+
//                ""+
//                "<ul style=\"list-style-type:circle;\">"+
//                "<li>The Guardian quotes BCG's Nikolaus Lang on the future of self-driving cars and robo-taxis.</li>"+
//                "<li>He says: By 2030, you’ll be a controlling passenger’ in your private self-driving car and you’ll be a ‘complete passenger’ in a robo-taxi.”</li>"+
//        "</ul>"+
//                ""+
//                "<ul>"+
//                "<li style=\"margin-top:0cm;margin-right:0cm;margin-bottom:9.0pt;\">Is Synthetic Motor Oil Better for Your Car?</li>"+
//                "</ul>"+
//                ""+
//                "<ul style=\"list-style-type:circle;\">"+
//                "<li style=\"margin-top:0cm;margin-right:0cm;margin-bottom:9.0pt;\">It might cost more at first look, but synthetic oil's performance and value are superior to conventional oil.</li>"+
//                "</ul>"+
//                ""+
//                "<h1 style=\"margin-top:0cm;margin-right:0cm;margin-bottom:9.0pt;margin-left:0cm;\">How Much Does an Oil Change Cost?</h1>"+
//                ""+
//                "<ul style=\"list-style-type:circle;\">"+
//                "<li style=\"margin-top:0cm;margin-right:0cm;margin-bottom:9.0pt;\">Oil changes are required maintenance, if you want your vehicle to run efficiently. But how much you pay for the service varies, depending on where you go.</li>"+
//                "</ul>"+
//                ""+
//                "<h3 style=\"margin-top:12.0pt;margin-right:0cm;margin-bottom:6.0pt;margin-left:0cm;\"><strong>                Synthetic oil vs. conventional oil</strong></h3>"+
//                ""+
//                "<ul style=\"list-style-type:circle;\">"+
//                "<li>Synthetic oil is exactly what it sounds like: an engine lubricant created artificially from chemical compounds.</li>"+
//                "<li>Some classes of synthetic oil start with conventional oil as a base that's  then chemically altered to produce synthetic oil, while others may be artificially created from other raw materials.</li>"+
//                "<li> In contrast, conventional motor oil (also referred to as standard oil or mineral-based oil), is refined from naturally occurring crude oil.</li>"+
//                "</ul>"+
//                ""+
//                "<h1 style=\"margin-top:0cm;margin-right:0cm;margin-bottom:9.0pt;margin-left:0cm;\"> </h1><p>The <a href=\"https://4html.net/Online-HTML-Editor-Text-to-HTML-Converter-870.html\"> online HTML editor</a> - a tool for handling web pages. </p>";
        WebSettings settings = webview.getSettings();
        settings.setMinimumFontSize(15);
        settings.setLoadWithOverviewMode(true);
        //settings.setUseWideViewPort(true);
        //settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);

       webview.setWebChromeClient(new WebChromeClient());


        //wb.loadUrl("file:///android_asset/inv.html");
        webview.getSettings().setJavaScriptEnabled(true);
       webview.loadDataWithBaseURL("", myvar2, "text/html", "UTF-8", "");
    }
}
