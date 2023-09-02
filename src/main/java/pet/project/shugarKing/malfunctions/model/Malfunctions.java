package pet.project.shugarKing.malfunctions.model;

import java.util.List;

//неисправности машины
public class Malfunctions {

    //колеса
    List<WheelFailures> wheels;

    //световые приборы
    List<LightingFixtureMalfunctions> lightingFixtures;

    //двери
    List<DoorMalfunctions> doors;

    //днище
    List<BottomMalfunctions> bottom;

}
