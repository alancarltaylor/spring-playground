package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by alantaylor on 2/19/17.
 */

@RestController
@RequestMapping("/dylan")
public class JsonFormController {
    public static class Genre{
        private String Type;

        @JsonProperty("type")
        public String getType(){
            return Type;

        }
        public void setType(String Type){
            this.Type = Type;
        }

    }

    public static class Home{
        private String HomeTown;
        private String HomeState;

        @JsonProperty("hometown")
        public String getHomeTown(){
            return HomeTown;
        }

        public void setHomeTown(String HomeTown){
            this.HomeTown = HomeTown;
        }

        @JsonProperty("homestate")
        public String getHomeState(){
            return HomeState;
        }

        public void setHomeState(String HomeState){
            this.HomeState = HomeState;
        }

    }

    public static class Fashion{
        private String EyeWear;
        private String HatWear;
        private String FootWear;

        @JsonProperty("hatwear")
        public String getHatWear(){
            return HatWear;
        }

        public void setHatWear(String HatWear){
            this.HatWear = HatWear;
        }

        @JsonProperty("footwear")
        public String getFootWear(){
            return FootWear;

        }

        public void setFootWear(String FootWear){
            this.FootWear = FootWear;
        }

        @JsonProperty("eyewear")
        public String getEyeWear(){
            return EyeWear;

        }

        public void setEyeWear(String EyeWear){
            this.EyeWear = EyeWear;
        }
    }

    @PostMapping("/genres")
    public String getGenre(@RequestBody Genre genre){
        return genre.getType();

    }

    @PostMapping("/hometown")
    public String getHomeStuff(@RequestBody Home home){
        return String.format("%s, %s", home.getHomeTown(), home.getHomeState());
    }

    @PostMapping("/fashion")
    public String getFashionStuff(@RequestBody Fashion fashion){
        return String.format("%s, %s, %s", fashion.getEyeWear(), fashion.getFootWear(), fashion.getHatWear());
    }
}
