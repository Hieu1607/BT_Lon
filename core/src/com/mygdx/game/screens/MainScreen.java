package com.mygdx.game.screens;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;


public class MainScreen implements Screen{
    private float elapsedTime = 0.0f;
    private static final float UPDATE_INTERVAL = 0.1f;
    public static final float speed = 100;
    Texture img;
    float x_coordinates, y_coordinates;
    MyGdxGame game;
    public MainScreen(MyGdxGame game){
        this.game = game;
    }
    public void show(){
        img = new Texture("Mainfish2.png");
        //ảnh cá tạm thời
    }
    private Vector2 lastMousePosition = new Vector2();
    public void render(float delta){
        // Cập nhật thời gian đã trôi qua
        elapsedTime += delta;

        if (elapsedTime >= UPDATE_INTERVAL) {
            // Lấy vị trí chuột hiện tại
            Vector2 currentMousePosition = new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
            // Tính độ chênh lệch giữa vị trí chuột hiện tại và trước đó
            float deltaX = currentMousePosition.x - lastMousePosition.x;
            System.out.println(lastMousePosition.x);
            System.out.println(currentMousePosition.x);
            // Cập nhật vị trí chuột trước đó
            lastMousePosition.x = currentMousePosition.x;
            // Quay chú cá dựa trên độ chênh lệch
            if (deltaX < 0) {
                img = new Texture("Mainfish2.png");
            }
            if (deltaX > 0) {
                // Quay sang phải
                img = new Texture("Mainfish1.png");
            }
            elapsedTime -= UPDATE_INTERVAL;
            System.out.println(lastMousePosition.x);
        }



        //Đặt vị trí cho cá chính
        x_coordinates = Gdx.input.getX()-30;
        y_coordinates = 690 - Gdx.input.getY();
        if(x_coordinates<0){
            x_coordinates = 0;
        }
        if(x_coordinates+img.getWidth()>Gdx.graphics.getWidth()){
            x_coordinates = Gdx.graphics.getWidth()- img.getWidth();
        }
        //di chuyển cá
        Gdx.gl.glClearColor(0.1f, 0.637f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //nền
        game.batch.begin();
        game.batch.draw(img, x_coordinates, y_coordinates, 80, 80);
        //vẽ cá
        game.batch.end();
    }
    public void resize(int width, int height){

    }
    public void pause(){

    }
    public void resume(){

    }
    public void hide(){

    }
    public void dispose(){

    }
}
