package com.example.gaintracker;

import com.example.gaintracker.objects.TreningObject;

public interface ButtonInterface {

    void buttonOnClick(TreningObject id);

    void deleteOnClick(TreningObject id, int position);

}
