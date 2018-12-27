public class ExampleApplet extends BaseGame { // Label: 1; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: ; Implementation: 11; Annotation: ; (ex. A,B = (dependencies on A and B)

    /**
     * We must set the screen dimensions to something
     */
    final int BLOCK = 16; // Label: 2; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
    final int screenWidth = 32 * BLOCK; // Label: 3; Control: ; Var: 2; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
    final int screenHeight = 27 * BLOCK; // Label: 4; Control: ; Var: 2; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

    /**
     * Gravity consists of a uniform downforce,
     * and a gravitational acceleration
     */
    float DOWN_FORCE = 2; // Label: 5; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
    float ACCELERATION = 1.3f; // Label: 6; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
    float DAMPENING = 0.75f; // Label: 7; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

    @Override // Label: 8; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 9; Annotation: ; (ex. A,B = (dependencies on A and B)
    public void settings() { // Label: 9; Control: ; Var: ; Type: ; Call: ; Effect: 10; Structure: 1; Implementation: ; Annotation: 8; (ex. A,B = (dependencies on A and B)
        // TODO: Customize screen size and so on here
        size(screenWidth, screenHeight); // Label: 10; Control: 9; Var: 3,4; Type: ; Call: ; Effect: ; Structure: 9; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
    } // Label: 9

    /**
     * initializing means building an "empty"
     * level, which we'll
     */
    void initialize() { // Label: 11; Control: ; Var: ; Type: ; Call: ; Effect: 12; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        frameRate(30); // Label: 12; Control: 11; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        reset(); // Label: 13; Control: 11; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
    } // Label: 11

    /**
     * Reset the entire game
     */
    void reset() { // Label: 14; Control: ; Var: ; Type: ; Call: ; Effect: 15; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        clearScreens(); // Label: 15; Control: 14; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        addScreen("MainLevel", new MainLevel(4 * width, height)); // Label: 16; Control: 14; Var: ; Type: 17,18; Call: ; Effect: ; Structure: 1; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
    } // Label: 14


    /**
     * Our "empty" level is a single layer
     * level, doing absolutely nothing.
     */
    class MainLevel extends Level { // Label: 17; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 18; Annotation: ; (ex. A,B = (dependencies on A and B)
        MainLevel(float levelWidth, float levelHeight) { // Label: 18; Control: ; Var: ; Type: ; Call: 16; Effect: ; Structure: 17; Implementation: 19; Annotation: ; (ex. A,B = (dependencies on A and B)
            super(levelWidth, levelHeight); // Label: 19; Control: 18; Var: 18; Type: ; Call: ; Effect: ; Structure: 18; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addLevelLayer("background layer", new MainBackgroundLayer(this)); // Label: 20; Control: 18; Var: ; Type: 25,27; Call: ; Effect: ; Structure: 18; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addLevelLayer("main layer", new MainLevelLayer(this)); // Label: 21; Control: 18; Var: ; Type: 33,35; Call: ; Effect: ; Structure: 18; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setViewBox(0, 0, screenWidth, screenHeight); // Label: 22; Control: 18; Var: 3,4; Type: ; Call: ; Effect: ; Structure: 18; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // And of course some background music!
            SoundManager.load(this, "audio/bg/Overworld.mp3"); // Label: 23; Control: 18; Var: ; Type: ; Call: ; Effect: ; Structure: 18; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.play(this); // Label: 24; Control: 18; Var: ; Type: ; Call: ; Effect: ; Structure: 18; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 18
    } // Label: 17


    /**
     * Our main level layer has a background
     * color, and nothing else.
     */
    class MainBackgroundLayer extends LevelLayer { // Label: 25; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 27; Annotation: ; (ex. A,B = (dependencies on A and B)
        Mario mario; // Label: 26; Control: ; Var: ; Type: 125; Call: ; Effect: ; Structure: 25; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

        MainBackgroundLayer(Level owner) { // Label: 27; Control: ; Var: ; Type: ; Call: 20; Effect: ; Structure: 25; Implementation: 28; Annotation: ; (ex. A,B = (dependencies on A and B)
            super(owner, owner.width, owner.height, 0, 0, 0.75f, 0.75f); // Label: 28; Control: 27; Var: 27; Type: ; Call: ; Effect: ; Structure: 27; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setBackgroundColor(color(0, 100, 190)); // Label: 29; Control: 27; Var: ; Type: ; Call: ; Effect: ; Structure: 27; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(new TilingSprite(new Sprite("graphics/backgrounds/sky_2.gif"), 0, 0, width, height)); // Label: 30; Control: 27; Var: ; Type: ; Call: ; Effect: ; Structure: 27; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 27

        void draw() { // Label: 31; Control: ; Var: ; Type: ; Call: ; Effect: 32; Structure: 25; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            super.draw(); // Label: 32; Control: 31; Var: ; Type: ; Call: ; Effect: ; Structure: 31; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 31
    } // Label: 25


    /**
     * Our main level layer has a background
     * color, and nothing else.
     */
    class MainLevelLayer extends LevelLayer { // Label: 33; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 35; Annotation: ; (ex. A,B = (dependencies on A and B)
        Mario mario; // Label: 34; Control: ; Var: ; Type: 125,128; Call: ; Effect: ; Structure: 33; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

        MainLevelLayer(Level owner) { // Label: 35; Control: ; Var: ; Type: ; Call: 21; Effect: ; Structure: 33; Implementation: 36; Annotation: ; (ex. A,B = (dependencies on A and B)
            super(owner); // Label: 36; Control: 35; Var: 35; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            //setBackgroundColor(color(0,130,255));
            addBackgroundSprite(new TilingSprite(new Sprite("graphics/backgrounds/sky.gif"), 0, 0, width, height)); // Label: 37; Control: 35; Var: ; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // set up Mario!
            mario = new Mario(); // Label: 38; Control: 35; Var: 34; Type: 125,128; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            mario.setPosition(32, height - 64); // Label: 39; Control: 35; Var: 34,38; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addPlayer(mario); // Label: 40; Control: 35; Var: 34,38; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // add a few slanted hills
            addSlant(256, height - 48); // Label: 41; Control: 35; Var: ; Type: 74; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addSlant(1300, height - 48); // Label: 42; Control: 35; Var: ; Type: 74; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addSlant(1350, height - 48); // Label: 43; Control: 35; Var: ; Type: 74; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // we don't want mario to walk off the level,
            // so let's add some side walls
            addBoundary(new Boundary(-1, 0, -1, height)); // Label: 44; Control: 35; Var: ; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBoundary(new Boundary(width + 1, height, width + 1, 0)); // Label: 45; Control: 35; Var: ; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // add general ground
            addGround("ground", -32, height - 48, -32 + 17 * 32, height); // Label: 46; Control: 35; Var: ; Type: 68; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBoundary(new Boundary(-32 + 17 * 32, height - 48, -32 + 17 * 32, height)); // Label: 47; Control: 35; Var: ; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            addInteractor(new Muncher(521, height - 8)); // Label: 48; Control: 35; Var: ; Type: 226,227; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addInteractor(new Muncher(536, height - 8)); // Label: 49; Control: 35; Var: ; Type: 226,227; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addInteractor(new Muncher(552, height - 8)); // Label: 50; Control: 35; Var: ; Type: 226,227; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addInteractor(new Muncher(567, height - 8)); // Label: 51; Control: 35; Var: ; Type: 226,227; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            addBoundary(new Boundary(-31 + 19 * 32, height, -31 + 19 * 32, height - 48)); // Label: 52; Control: 35; Var: ; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addGround("ground", -31 + 19 * 32, height - 48, width + 32, height); // Label: 53; Control: 35; Var: ; Type: 68: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // add some ground platforms
            addGroundPlatform("ground", 928, height - 224, 96, 112); // Label: 54; Control: 35; Var: ; Type: 80; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addCoins(928, height - 236, 96); // Label: 55; Control: 35; Var: ; Type: 99; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addGroundPlatform("ground", 920, height - 176, 32, 64); // Label: 56; Control: 35; Var: ; Type: 80; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addGroundPlatform("ground", 912, height - 128, 128, 80); // Label: 57; Control: 35; Var: ; Type: 80; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addCoins(912, height - 140, 128); // Label: 58; Control: 35; Var: ; Type: 99; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addGroundPlatform("ground", 976, height - 96, 128, 48); // Label: 59; Control: 35; Var: ; Type: 80; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addGroundPlatform("ground", 1442, height - 128, 128, 80); // Label: 60; Control: 35; Var: ; Type: 80; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addCoins(1442, height - 140, 128); // Label: 61; Control: 35; Var: ; Type: 99; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addGroundPlatform("ground", 1442 + 64, height - 96, 128, 48); // Label: 62; Control: 35; Var: ; Type: 80; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // mystery coins
            addForPlayerOnly(new DragonCoin(352, height - 164)); // Label: 63; Control: 35; Var: ; Type: 251,252; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // Let's also add a koopa on one of the slides
            Koopa koopa = new Koopa(264, height - 178); // Label: 64; Control: 35; Var: ; Type: 199,200; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addInteractor(koopa); // Label: 65; Control: 35; Var: 64; Type: ; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // add lots of just-in-time triggers
            addTriggers(); // Label: 66; Control: 35; Var: ; Type: 116; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // and let's add the thing that makes us win!
            addGoal(1920, height - 48); // Label: 67; Control: 35; Var: ; Type: 105; Call: ; Effect: ; Structure: 35; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 35

        /**
         * Add some ground.
         */
        void addGround(String tileset, float x1, float y1, float x2, float y2) { // Label: 68; Control: ; Var: ; Type: ; Call: 46,53; Effect: 70,72,73; Structure: 33; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            TilingSprite groundline = new TilingSprite(new Sprite("graphics/backgrounds/" + tileset + "-top.gif"), x1, y1, x2, y1 + 16); // Label: 69; Control: 68; Var: 68; Type: ; Call: ; Effect: ; Structure: 68; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(groundline); // Label: 70; Control: 68; Var: 69; Type: ; Call: ; Effect: ; Structure: 68; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            TilingSprite groundfiller = new TilingSprite(new Sprite("graphics/backgrounds/" + tileset + "-filler.gif"), x1, y1 + 16, x2, y2); // Label: 71; Control: 68; Var: 68; Type: ; Call: ; Effect: ; Structure: 68; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(groundfiller); // Label: 72; Control: 68; Var: 71; Type: ; Call: ; Effect: ; Structure: 68; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBoundary(new Boundary(x1, y1, x2, y1)); // Label: 73; Control: 68; Var: 68; Type: ; Call: ; Effect: ; Structure: 68; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 68

        /**
         * This creates the raised, angled sticking-out-ground bit.
         * it's actually a sprite, not a rotated generated bit of ground.
         */
        void addSlant(float x, float y) { // Label: 74; Control: ; Var: ; Type: ; Call: ; Effect: 78,79; Structure: 33; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            Sprite groundslant = new Sprite("graphics/backgrounds/ground-slant.gif"); // Label: 75; Control: 74; Var: ; Type: ; Call: ; Effect: ; Structure: 74; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            groundslant.align(LEFT, BOTTOM); // Label: 76; Control: 74; Var: 75; Type: ; Call: ; Effect: ; Structure: 74; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            groundslant.setPosition(x, y); // Label: 77; Control: 74; Var: 74,75; Type: ; Call: ; Effect: ; Structure: 74; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(groundslant); // Label: 78; Control: 74; Var: 75; Type: ; Call: ; Effect: ; Structure: 74; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBoundary(new Boundary(x, y + 48 - groundslant.height, x + 48, y - groundslant.height)); // Label: 79; Control: 74; Var: 74,75; Type: ; Call: ; Effect: ; Structure: 74; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 74

        /**
         * Add a platform with solid ground underneath.
         */
        void addGroundPlatform(String tileset, float x, float y, float w, float h) { // Label: 80; Control: ; Var: ; Type: ; Call: 54,56,57,59,60,62; Effect: 89,90,91,95,96,97,98; Structure: 33; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // top layer
            Sprite lc = new Sprite("graphics/backgrounds/" + tileset + "-corner-left.gif"); // Label: 81; Control: 80; Var: 80; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            lc.align(LEFT, TOP); // Label: 82; Control: 80; Var: 81; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            lc.setPosition(x, y); // Label: 83; Control: 80; Var: 80,81; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            Sprite tp = new Sprite("graphics/backgrounds/" + tileset + "-top.gif"); // Label: 84; Control: 80; Var: 80; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            Sprite rc = new Sprite("graphics/backgrounds/" + tileset + "-corner-right.gif"); // Label: 85; Control: 80; Var: 80; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            rc.align(LEFT, TOP); // Label: 86; Control: 80; Var: 85; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            rc.setPosition(x + w - rc.width, y); // Label: 87; Control: 80; Var: 80,85; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            TilingSprite toprow = new TilingSprite(tp, x + lc.width, y, x + (w - rc.width), y + tp.height); // Label: 88; Control: 80; Var: 80,81,84,85; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            addBackgroundSprite(lc); // Label: 89; Control: 80; Var: 81; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(toprow); // Label: 90; Control: 80; Var: 88; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(rc); // Label: 91; Control: 80; Var: 85; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // sides/filler
            TilingSprite sideleft = new TilingSprite(new Sprite("graphics/backgrounds/" + tileset + "-side-left.gif"), x, y + tp.height, x + lc.width, y + h); // Label: 92; Control: 80; Var: 80,81,84; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            TilingSprite filler = new TilingSprite(new Sprite("graphics/backgrounds/" + tileset + "-filler.gif"), x + lc.width, y + tp.height, x + (w - rc.width), y + h); // Label: 93; Control: 80; Var: 80,81,84,85; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            TilingSprite sideright = new TilingSprite(new Sprite("graphics/backgrounds/" + tileset + "-side-right.gif"), x + w - rc.width, y + tp.height, x + w, y + h); // Label: 94; Control: 80; Var: 84,85; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            addBackgroundSprite(sideleft); // Label: 95; Control: 80; Var: 92; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(filler); // Label: 96; Control: 80; Var: 93; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(sideright); // Label: 97; Control: 80; Var: 94; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // boundary to walk on
            addBoundary(new Boundary(x, y, x + w, y)); // Label: 98; Control: 80; Var: 80; Type: ; Call: ; Effect: ; Structure: 80; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 80

        // add coins over a horizontal stretch
        void addCoins(float x, float y, float w) { // Label: 99; Control: ; Var: ; Type: ; Call: 55,58,61; Effect: 102; Structure: 33; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            float step = 16; // Label: 100; Control: 99; Var: ; Type: ; Call: ; Effect: ; Structure: 99; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            float i = 0; // Label: 101; Control: 99; Var: ; Type: ; Call: ; Effect: ; Structure: 99; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            float last = w / step; // Label: 102; Control: 99; Var: 99,100; Type: ; Call: ; Effect: ; Structure: 99; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            for (i = 0; i < last; i++) { // Label: 103; Control: 99; Var: 101,102; Type: ; Call: ; Effect: ; Structure: 99; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                addForPlayerOnly(new Coin(x + 8 + i * step, y)); // Label: 104; Control: 103; Var: 99,100,103; Type: 534,535; Call: ; Effect: ; Structure: 99; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 103
        } // Label: 99

        // And finally, the end of the level!
        void addGoal(float xpos, float hpos) { // Label: 105; Control: ; Var: ; Type: ; Call: 67; Effect: 110,114,115; Structure: 33; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            hpos += 1; // Label: 106; Control: 105; Var: 105; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // background post
            Sprite goal_b = new Sprite("graphics/assorted/Goal-back.gif"); // Label: 107; Control: 105; Var: ; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            goal_b.align(CENTER, BOTTOM); // Label: 108; Control: 105; Var: 107; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            goal_b.setPosition(xpos, hpos); // Label: 109; Control: 105; Var: 105,107; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addBackgroundSprite(goal_b); // Label: 110; Control: 105; Var: 107; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // foreground post
            Sprite goal_f = new Sprite("graphics/assorted/Goal-front.gif"); // Label: 111; Control: 105; Var: ; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            goal_f.align(CENTER, BOTTOM); // Label: 112; Control: 105; Var: 111; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            goal_f.setPosition(xpos + 32, hpos); // Label: 113; Control: 105; Var: 105,111; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addForegroundSprite(goal_f); // Label: 114; Control: 105; Var: 111; Type: ; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // the finish line rope
            addForPlayerOnly(new Rope(xpos, hpos - 16)); // Label: 115; Control: 105; Var: 105; Type: 258; Call: ; Effect: ; Structure: 105; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 105

        // In order to effect "just-in-time" sprite placement,
        // we set up some trigger regions.
        void addTriggers() { // Label: 116; Control: ; Var: ; Type: ; Call: 66; Effect: 117,118,119; Structure: 116; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addTrigger(new KoopaTrigger(412, 0, 5, height, 350, height - 64, -0.2f, 0)); // Label: 117; Control: 116; Var: ; Type: 275; Call: ; Effect: ; Structure: 116; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addTrigger(new KoopaTrigger(562, 0, 5, height, 350, height - 64, -0.2f, 0)); // Label: 118; Control: 116; Var: ; Type: 275; Call: ; Effect: ; Structure: 116; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addTrigger(new KoopaTrigger(916, 0, 5, height, 350, height - 64, -0.2f, 0)); // Label: 119; Control: 116; Var: ; Type: 275; Call: ; Effect: ; Structure: 116; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 116

        void draw() { // Label: 120; Control: ; Var: ; Type: ; Call: ; Effect: 121,124; Structure: 33; Implementation: 121; Annotation: ; (ex. A,B = (dependencies on A and B)
            super.draw(); // Label: 121; Control: 120; Var: ; Type: ; Call: ; Effect: ; Structure: 120; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            viewbox.track(parent, mario); // Label: 122; Control: 120; Var: 34,38; Type: ; Call: ; Effect: ; Structure: 120; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // just in case!
            if (mario != null && mario.active != null && mario.active.name != "dead" && mario.y > height) { // Label: 123; Control: 120; Var: 34; Type: ; Call: ; Effect: ; Structure: 120; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                reset(); // Label: 124; Control: 123; Var: ; Type: ; Call: ; Effect: ; Structure: 120; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 123
        } // Label: 120
    } // Label: 33


    //////////////
    //  ACTORS  //
    //////////////


    /**
     * Our dapper mustachioed hero
     */
    class Mario extends Player { // Label: 125; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 128; Annotation: ; (ex. A,B = (dependencies on A and B)

        int score = 0; // Label: 126; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 125; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        float speed = 2; // Label: 127; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 125; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

        Mario() { // Label: 128; Control: ; Var: ; Type: ; Call: 38; Effect: ; Structure: 125; Implementation: 129; Annotation: ; (ex. A,B = (dependencies on A and B)
            super("Mario"); // Label: 129; Control: 128; Var: ; Type: ; Call: ; Effect: ; Structure: 128; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setStates(); // Label: 130; Control: 128; Var: ; Type: 138; Call: ; Effect: ; Structure: 128; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            handleKey('W'); // Label: 131; Control: 128; Var: ; Type: ; Call: ; Effect: ; Structure: 128; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            handleKey('A'); // Label: 132; Control: 128; Var: ; Type: ; Call: ; Effect: ; Structure: 128; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            handleKey('S'); // Label: 133; Control: 128; Var: ; Type: ; Call: ; Effect: ; Structure: 128; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            handleKey('D'); // Label: 134; Control: 128; Var: ; Type: ; Call: ; Effect: ; Structure: 128; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setImpulseCoefficients(DAMPENING, DAMPENING); // Label: 135; Control: 128; Var: ; Type: ; Call: ; Effect: ; Structure: 128; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setForces(0, DOWN_FORCE); // Label: 136; Control: 128; Var: ; Type: ; Call: ; Effect: ; Structure: 128'; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setAcceleration(0, ACCELERATION); // Label: 137; Control: 128; Var: ; Type: ; Call: ; Effect: ; Structure: 128; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 128

        /**
         * Set up our states
         */
        void setStates() { // Label: 138; Control: ; Var: ; Type: ; Call: 130; Effect: ; Structure: 125; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // idling state
            addState(new State("idle", "graphics/mario/small/Standing-mario.gif")); // Label: 139; Control: 138; Var: ; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // running state
            addState(new State("running", "graphics/mario/small/Running-mario.gif", 1, 4)); // Label: 140; Control: 138; Var: ; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // dead state O_O
            State dead = new State("dead", "graphics/mario/small/Dead-mario.gif", 1, 2); // Label: 141; Control: 138; Var: ; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            dead.setAnimationSpeed(0.25f); // Label: 142; Control: 138; Var: 141; Type: ; Call: ; Effect: ; Structure: 141; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            dead.setDuration(100); // Label: 143; Control: 138; Var: 141; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addState(dead); // Label: 144; Control: 138; Var: 141; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.load(dead, "audio/Dead mario.mp3"); // Label: 145; Control: 138; Var: 141; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // jumping state
            State jumping = new State("jumping", "graphics/mario/small/Jumping-mario.gif"); // Label: 146; Control: 138; Var: ; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            jumping.setDuration(15); // Label: 147; Control: 138; Var: 146; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addState(jumping); // Label: 148; Control: 138; Var: 146; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.load(jumping, "audio/Jump.mp3"); // Label: 149; Control: 138; Var: 146; Type: ; Call: ; Effect: ; Structure: 138]; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // victorious state!
            State won = new State("won", "graphics/mario/small/Standing-mario.gif"); // Label: 150; Control: 138; Var: ; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            won.setDuration(240); // Label: 151; Control: 138; Var: 150; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addState(won); // Label: 152; Control: 138; Var: 150; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // default: just stand around doing nothing
            setCurrentState("idle"); // Label: 153; Control: 138; Var: 139; Type: ; Call: ; Effect: ; Structure: 138; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 138

        /**
         * Handle input
         */
        void handleInput() { // Label: 154; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 125; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // we don't handle any input when we're dead~
            if (active.name == "dead" || active.name == "won") return; // Label: 155; Control: 154; Var: 144,148; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // what do we "do"? (i.e. movement wise)
            if (isKeyDown('A') || isKeyDown('D')) { // Label: 156; Control: 155; Var: 132,134; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                if (isKeyDown('A')) { // Label: 157; Control: 156; Var: 132; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    // when we walk left, we need to flip the sprite
                    setHorizontalFlip(true); // Label: 158; Control: 157; Var: ; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    // walking left means we get a negative impulse along the x-axis:
                    addImpulse(-speed, 0); // Label: 159; Control: 157; Var: 127; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    // and we set the viewing direction to "left"
                    setViewDirection(-1, 0); // Label: 160; Control: 157; Var: ; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                } // Label: 157
                if (isKeyDown('D')) { // Label: 161; Control: 156; Var: 134; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    // when we walk right, we need to NOT flip the sprite =)
                    setHorizontalFlip(false); // Label: 162; Control: 161; Var: ; Type: ; Call: ; Effect: ; Structure: 161; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    // walking right means we get a positive impulse along the x-axis:
                    addImpulse(speed, 0); // Label: 163; Control: 161; Var: 127; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    // and we set the viewing direction to "right"
                    setViewDirection(1, 0); // Label: 164; Control: 161; Var: ; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                } // Label: 161
            } // Label: 156

            // if the jump key is pressed, and we're standing on something,
            // let's jump!
            if (isKeyDown('W') && active.name != "jumping" && boundaries.size() > 0) { // Label: 165; Control: 155; Var: 131,149; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                // generate a massive impulse upward
                addImpulse(0, -35); // Label: 166; Control: 165; Var: ; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                // and make sure we look like we're jumping, too
                setCurrentState("jumping"); // Label: 167; Control: 165; Var: 148; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                SoundManager.play(active); // Label: 168; Control: 165; Var: ; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 165

            // and what do we look like when we do this?
            if (active.mayChange()) { // Label: 169; Control: 155; Var: ; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                // if we're not jumping, but left or right is pressed,
                // make sure we're using the "running" state.
                if (isKeyDown('A') || isKeyDown('D')) { // Label: 170; Control: 169; Var: 132,134; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    setCurrentState("running"); // Label: 171; Control: 170; Var: 140; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                } // Label: 170

                // if we're not actually doing anything,
                // then we change the state to "idle"
                else { // Label: 170
                    setCurrentState("idle"); // Label: 172; Control: 170; Var: 153; Type: ; Call: ; Effect: ; Structure: 154; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                } // Label: 170
            } // Label: 169
        } // Label: 154

        /**
         * When 'fixed frame count' animations end
         * such as the jump animation, what should we do?
         */
        void handleStateFinished(State which) { // Label: 173; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 125; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            if (which.name == "dead" || which.name == "won") { // Label: 174; Control: 173; Var: 144,152; Type: ; Call: ; Effect: ; Structure: 173; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                removeActor(); // Label: 175; Control: 174; Var: ; Type: ; Call: ; Effect: ; Structure: 174; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                reset(); // Label: 176; Control: 174; Var: ; Type: ; Call: ; Effect: ; Structure: 173; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } else { // Label: 174
                setCurrentState("idle"); // Label: 177; Control: 174; Var: 139; Type: ; Call: ; Effect: ; Structure: ; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 174
        } // Label: 173

        /**
         * What happens when we touch another actor?
         */
        void overlapOccurredWith(Actor other, float[] direction) { // Label: 178; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 125; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            if (other instanceof Koopa) { // Label: 179; Control: 178; Var: 178; Type: 199; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                Koopa koopa = (Koopa) other; // Label: 180; Control: 179; Var: 178; Type: 199; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                float angle = direction[2]; // Label: 181; Control: 178; Var: 178; Type: ; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

                // We bopped a koopa on the head!
                float tolerance = radians(75); // Label: 182; Control: 179; Var: ; Type: ; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                if (PI / 2 - tolerance <= angle && angle <= PI / 2 + tolerance) { // Label: 183; Control: 178; Var: 181,182; Type: ; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    koopa.squish(); // Label: 184; Control: 183; Var: 180; Type: 220; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    stop(0, 0); // Label: 185; Control: 183; Var: ; Type: ; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    setImpulse(0, -30); // Label: 186; Control: 183; Var: ; Type: ; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                    setCurrentState("jumping"); // Label: 187; Control: 183; Var: 148; Type: ; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                } // Label: 183

                // Oh no! We missed and touched a koopa!
                else { // Label: 183
                    die(); // Label: 184; Control: 183; Var: ; Type: 185; Call: ; Effect: ; Structure: 178; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                } // Label: 183
            } // Label: 179
        } // Label: 178

        /**
         * When we die, we need to go in the funky "oh no we lost~" dance dive.
         */
        void die() { // Label: 185; Control: ; Var: ; Type: ; Call: ; Effect: 186,187,188,189; Structure: 125; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setCurrentState("dead"); // Label: 186; Control: 185; Var: 141; Type: ; Call: ; Effect: ; Structure: 185; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setInteracting(false); // Label: 187; Control: 185; Var: ; Type: ; Call: ; Effect: ; Structure: 185; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addImpulse(0, -30); // Label: 188; Control: 185; Var: ; Type: ; Call: ; Effect: ; Structure: 185; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setForces(0, 3); // Label: 189; Control: 185; Var: ; Type: ; Call: ; Effect: ; Structure: 185; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // stop background music!
            SoundManager.stop(getLevelLayer().getLevel()); // Label: 190; Control: 185; Var: ; Type: 17,82; Call: ; Effect: ; Structure: 185; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // play sad music =(
            SoundManager.play(active); // Label: 191; Control: 185; Var: ; Type: ; Call: ; Effect: ; Structure: 185; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 185

        /**
         * What happens when we get pickups?
         */
        void pickedUp(Pickup pickup) { // Label: 192; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 125; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // we got some points
            if (pickup.name == "Regular coin") { // Label: 193; Control: 192; Var: 192; Type: 245; Call: ; Effect: ; Structure: 192; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                score++; // Label: 194; Control: 193; Var: 126; Type: ; Call: ; Effect: ; Structure: 192; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 193
            // we got big points
            else if (pickup.name == "Dragon coin") { // Label: 195; Control: 193; Var: 192; Type: 251; Call: ; Effect: ; Structure: 192; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                score += 100; // Label: 196; Control: 195; Var: 126; Type: ; Call: ; Effect: ; Structure: 192; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 195
            // we won!
            else if (pickup.name == "Finish line") { // Label: 197; Control: 195; Var: 192; Type: 257; Call: ; Effect: ; Structure: 192; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                setCurrentState("won"); // Label: 198; Control: 197; Var: 152; Type: ; Call: ; Effect: ; Structure: 192; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 197
        } // Label: 192
    } // Label: 125


    /**
     * Our main enemy in this game
     */
    class Koopa extends Interactor { // Label: 199; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 200; Annotation: ; (ex. A,B = (dependencies on A and B)

        Koopa(float x, float y) { // Label: 200; Control: ; Var: ; Type: 200; Call: 64; Effect: 203,204,205; Structure: 199; Implementation: 201; Annotation: ; (ex. A,B = (dependencies on A and B)
            super("Koopa Trooper"); // Label: 201; Control: 200; Var: ; Type: ; Call: ; Effect: ; Structure: 200; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setStates(); // Label: 202; Control: 200; Var: ; Type: 206; Call: ; Effect: ; Structure: 200; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setForces(-0.25f, DOWN_FORCE); // Label: 203; Control: 200; Var: ; Type: ; Call: ; Effect: ; Structure: 200; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setImpulseCoefficients(DAMPENING, DAMPENING); // Label: 204; Control: 200; Var: ; Type: ; Call: ; Effect: ; Structure: 200; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setPosition(x, y); // Label: 205; Control: 200; Var: 200; Type: ; Call: ; Effect: ; Structure: 200; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 200

        /**
         * Set up our states
         */
        void setStates() { // Label: 206; Control: ; Var: ; Type: ; Call: 202; Effect: ; Structure: 199; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // walking state
            State walking = new State("idle", "graphics/enemies/Red-koopa-walking.gif", 1, 2); // Label: 207; Control: 206; Var: ; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            walking.setAnimationSpeed(0.12f); // Label: 208; Control: 206; Var: 207; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.load(walking, "audio/Squish.mp3"); // Label: 209; Control: 206; Var: 207; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addState(walking); // Label: 210; Control: 206; Var: 207; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // if we get squished, we first get naked...
            State naked = new State("naked", "graphics/enemies/Naked-koopa-walking.gif", 1, 2); // Label: 211; Control: 206; Var: ; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            naked.setAnimationSpeed(0.12f); // Label: 212; Control: 206; Var: 211; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.load(naked, "audio/Squish.mp3"); // Label: 213; Control: 206; Var: 211; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addState(naked); // Label: 214; Control: 206; Var: 211; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            setCurrentState("idle"); // Label: 215; Control: 206; Var: 210; Type: ; Call: ; Effect: ; Structure: 206; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 206

        /**
         * when we hit a vertical wall, we want our
         * koopa to reverse direction
         */
        void gotBlocked(Boundary b, float[] intersection) { // Label: 216; Control: ; Var: ; Type: ; Call: ; Effect: 218,219; Structure: 199; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            if (b.x == b.xw) { // Label: 217; Control: 216; Var: 216; Type: ; Call: ; Effect: ; Structure: 216; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                fx = -fx; // Label: 218; Control: 217; Var: ; Type: ; Call: ; Effect: ; Structure: 216; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                setHorizontalFlip(fx > 0); // Label: 219; Control: 217; Var: 218; Type: ; Call: ; Effect: ; Structure: 216; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 217
        } // Label: 216

        void squish() { // Label: 220; Control: ; Var: ; Type: ; Call: 184; Effect: 223,225; Structure: 199; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.play(active); // Label: 221; Control: 220; Var: ; Type: ; Call: ; Effect: ; Structure: 220; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

            // do we have our shell? Then we only get half-squished.
            if (active.name != "naked") { // Label: 222; Control: 220; Var: ; Type: ; Call: ; Effect: ; Structure: 220; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                setCurrentState("naked"); // Label: 223; Control: 222; Var: 214; Type: ; Call: ; Effect: ; Structure: 220; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                return; // Label: 224; Control: 222; Var: ; Type: ; Call: ; Effect: ; Structure: 220; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 222

            // no shell... this koopa is toast.
            removeActor(); // Label: 225; Control: 222; Var: ; Type: ; Call: ; Effect: ; Structure: 220; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 220
    } // Label: 199


    /**
     * The muncher plant. To touch it is to lose.
     */
    class Muncher extends Interactor { // Label: 226; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 227; Annotation: ; (ex. A,B = (dependencies on A and B)

        Muncher(float x, float y) { // Label: 227; Control: ; Var: ; Type: ; Call: 48,49,50,51; Effect: 229; Structure: 226; Implementation: 228; Annotation: ; (ex. A,B = (dependencies on A and B)
            super("Muncher"); // Label: 228; Control: 227; Var: ; Type: ; Call: ; Effect: ; Structure: 227; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setPosition(x, y); // Label: 229; Control: 227; Var: 227; Type: ; Call: ; Effect: ; Structure: 227; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            setupStates(); // Label: 230; Control: 227; Var: ; Type: 231; Call: ; Effect: ; Structure: 227; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 227

        void setupStates() { // Label: 231; Control: ; Var: ; Type: ; Call: 230; Effect: 234; Structure: 226; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            State munch = new State("munch", "graphics/enemies/Muncher.gif", 1, 2); // Label: 232; Control: 231; Var: ; Type: ; Call: ; Effect: ; Structure: 231; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            munch.setAnimationSpeed(0.20f); // Label: 233; Control: 231; Var: 232; Type: ; Call: ; Effect: ; Structure: 231; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            addState(munch); // Label: 234; Control: 231; Var: 232; Type: ; Call: ; Effect: ; Structure: 231; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 231

        void overlapOccurredWith(Actor other, float[] overlap) { // Label: 235; Control: ; Var: ; Type: ; Call: ; Effect: 238; Structure: 226; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            super.overlapOccurredWith(other, overlap); // Label: 236; Control: 235; Var: 235; Type: ; Call: ; Effect: ; Structure: 235; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            if (other instanceof Mario) { // Label: 237; Control: 235; Var: 235; Type: 125; Call: ; Effect: ; Structure: 235; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                ((Mario) other).die(); // Label: 238; Control: 235; Var: 235; Type: 125,185; Call: ; Effect: ; Structure: 235; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 237
        } // Label: 235
    } // Label: 226


    /////////////////
    //   PICKUPS   //
    /////////////////


    /**
     * All pickups in Mario may move, and if
     * they do, they will bounce when hitting
     * a clean boundary.
     */
    class MarioPickup extends Pickup { // Label: 238; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 239; Annotation: ; (ex. A,B = (dependencies on A and B)
        MarioPickup(String name, String spritesheet, int rows, int columns, float x, float y, boolean visible) { // Label: 239; Control: ; Var: ; Type: 238; Call: 247,253,259; Effect: 240; Structure: 238; Implementation: 240; Annotation: ; (ex. A,B = (dependencies on A and B)
            super(name, spritesheet, rows, columns, x, y, visible); // Label: 241; Control: 239; Var: 239; Type: ; Call: ; Effect: ; Structure: 239; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 239

        void gotBlocked(Boundary b, float[] intersection) { // Label: 242; Control: ; Var: ; Type: ; Call: ; Effect: 244,245; Structure: 238; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            if (intersection[0] - x == 0 && intersection[1] - y == 0) { // Label: 243; Control: 242; Var: 242; Type: ; Call: ; Effect: ; Structure: 242; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                fx = -fx; // Label: 244; Control: 243; Var: ; Type: ; Call: ; Effect: ; Structure: 242; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                active.sprite.flipHorizontal(); // Label: 244; Control: 243; Var: ; Type: ; Call: ; Effect: ; Structure: 242; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 243
        } // Label: 242
    } // Label: 238


    /**
     * A regular coin
     */
    class Coin extends MarioPickup { // Label: 245; Control: ; Var: ; Type: 238; Call: ; Effect: ; Structure: 1; Implementation: 246; Annotation: ; (ex. A,B = (dependencies on A and B)
        Coin(float x, float y) { // Label: 246; Control: ; Var: ; Type: 245; Call: 104; Effect: 247; Structure: 245; Implementation: 247; Annotation: ; (ex. A,B = (dependencies on A and B)
            super("Regular coin", "graphics/assorted/Regular-coin.gif", 1, 4, x, y, true); // Label: 247; Control: 246; Var: 246; Type: 239; Call: ; Effect: ; Structure: 246; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.load(this, "audio/Coin.mp3"); // Label: 248; Control: 246; Var: ; Type: ; Call: ; Effect: ; Structure: 246; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 246

        void pickedUp() { // Label: 249; Control: ; Var: ; Type: ; Call: ; Effect: 250; Structure: 245; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.play(this); // Label: 250; Control: 249; Var: ; Type: ; Call: ; Effect: ; Structure: 249; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 249
    } // Label: 245


    /**
     * A dragon coin!
     */
    class DragonCoin extends MarioPickup { // Label: 251; Control: ; Var: ; Type: 238; Call: ; Effect: ; Structure: 1; Implementation: 252; Annotation: ; (ex. A,B = (dependencies on A and B)
        DragonCoin(float x, float y) { // Label: 252; Control: ; Var: ; Type: ; Call: 63; Effect: 253; Structure: 251; Implementation: 253; Annotation: ; (ex. A,B = (dependencies on A and B)
            super("Dragon coin", "graphics/assorted/Dragon-coin.gif", 1, 10, x, y, true); // Label: 253; Control: 252; Var: 252; Type: 239; Call: ; Effect: ; Structure: 251; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.load(this, "audio/Dragon coin.mp3"); // Label: 254; Control: 252; Var: ; Type: ; Call: ; Effect: ; Structure: 252; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 252

        void pickedUp() { // Label: 255; Control: ; Var: ; Type: ; Call: ; Effect: 256; Structure: 251; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.play(this); // Label: 256; Control: 255; Var: ; Type: ; Call: ; Effect: ; Structure: 255; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 255
    } // Label: 251


    /**
     * The finish line is also a pickup,
     * and will trigger the "clear" state
     * for the level when picked up.
     */
    class Rope extends MarioPickup { // Label: 257; Control: ; Var: ; Type: 238; Call: ; Effect: ; Structure: 1; Implementation: 258; Annotation: ; (ex. A,B = (dependencies on A and B)
        Rope(float x, float y) { // Label: 258; Control: ; Var: ; Type: 257; Call: 115; Effect: 259,261,262,263; Structure: 257; Implementation: 259; Annotation: ; (ex. A,B = (dependencies on A and B)
            super("Finish line", "graphics/assorted/Goal-slider.gif", 1, 1, x, y, true); // Label: 259; Control: 258; Var: 258; Type: 239; Call: ; Effect: ; Structure: 258; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            Sprite s = getState("Finish line").sprite; // Label: 260; Control: 258; Var: 259; Type: ; Call: ; Effect: ; Structure: 258; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            s.align(LEFT, TOP); // Label: 261; Control: 258; Var: 260; Type: ; Call: ; Effect: ; Structure: 258; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            s.setNoRotation(true); // Label: 262; Control: 258; Var: 260; Type: ; Call: ; Effect: ; Structure: 258; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            s.addPathLine(0, 0, 1, 1, 0, 0, -116, 1, 1, 0, 50); // Label: 263; Control: 258; Var: 260; Type: ; Call: ; Effect: ; Structure: 258; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            s.addPathLine(0, -116, 1, 1, 0, 0, 0, 1, 1, 0, 50); // Label: 264; Control: 258; Var: 260; Type: ; Call: ; Effect: ; Structure: 258; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            s.setLooping(true); // Label: 265; Control: 258; Var: 260; Type: ; Call: ; Effect: ; Structure: 258; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            SoundManager.load(this, "audio/bg/Course-clear.mp3"); // Label: 266; Control: 258; Var: ; Type: ; Call: ; Effect: ; Structure: 258; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 258

        void pickedUp() { // Label: 267; Control: ; Var: ; Type: ; Call: ; Effect: 268,269; Structure: 257; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // stop background music!
            SoundManager.stop(getLevelLayer().getLevel()); // Label: 268; Control: 267; Var: ; Type: 17,82; Call: ; Effect: ; Structure: 267; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // play victory music!
            SoundManager.play(this); // Label: 269; Control: 267; Var: ; Type: ; Call: ; Effect: ; Structure: 267; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 267
    } // Label: 257


    ////////////////
    //  TRIGGERS  //
    ////////////////

    /**
     * triggers a koopa trooper 350px to the right
     */
    class KoopaTrigger extends Trigger { // Label: 270; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 1; Implementation: 275; Annotation: ; (ex. A,B = (dependencies on A and B)
        float kx; // Label: 271; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 270; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        float ky; // Label: 272; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 270; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        float fx; // Label: 273; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 270; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        float fy;  // Label: 274; Control: ; Var: ; Type: ; Call: ; Effect: ; Structure: 270; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)

        KoopaTrigger(float x, float y, float w, float h, float _kx, float _ky, float _fx, float _fy) { // Label: 275; Control: ; Var: ; Type: 270; Call: 117,118,119; Effect: 276,277,278,279,280; Structure: 270; Implementation: 276; Annotation: ; (ex. A,B = (dependencies on A and B)
            super("koopa", x, y, w, h); // Label: 276; Control: ; Var: 275; Type: ; Call: ; Effect: ; Structure: 275; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            kx = _kx; // Label: 277; Control: 275; Var: 271,275; Type: ; Call: ; Effect: ; Structure: 275; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            ky = _ky; // Label: 278; Control: 275; Var: 272,275; Type: ; Call: ; Effect: ; Structure: 275; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            fx = _fx; // Label: 279; Control: 275; Var: 273,275; Type: ; Call: ; Effect: ; Structure: 275; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            fy = _fy; // Label: 280; Control: 275; Var: 274,275; Type: ; Call: ; Effect: ; Structure: 275; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 275

        void run(LevelLayer layer, Actor actor, float[] intersection) { // Label: 281; Control: ; Var: ; Type: ; Call: ; Effect: 282,284,285,286; Structure: 270; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            Koopa k = new Koopa(x + kx, ky); // Label: 282; Control: 281; Var: 271,272,277,278; Type: 199,200; Call: ; Effect: ; Structure: 281; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            if (fx > 0) { // Label: 283; Control: 281; Var: 273,279; Type: ; Call: ; Effect: ; Structure: 281; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
                k.setHorizontalFlip(true); // Label: 284; Control: 283; Var: 282; Type: ; Call: ; Effect: ; Structure: 281; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            } // Label: 283
            layer.addInteractor(k); // Label: 285; Control: 281; Var: 281,282; Type: ; Call: ; Effect: ; Structure: 281; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
            // remove this trigger so that it's not repeated
            removeTrigger(); // Label: 286; Control: 281; Var: ; Type: ; Call: ; Effect: ; Structure: 281; Implementation: ; Annotation: ; (ex. A,B = (dependencies on A and B)
        } // Label: 281
    } // Label: 270
} // Label: 1
