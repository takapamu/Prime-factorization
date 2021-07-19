#include<iostream>  //標準出力
#include<random> //乱数生成

#define DECK 52
#define MIN_DECK 1
#define MAX_DECK 10

class Deck_Pcard
{
  private:
    int deck_num; //デッキ数
    int card_num; //カード枚数
    int *deck; //格納配列
    int *p_deck;//配列戦闘ポインタ

  public:
  Deck_Pcard(int input_deck_num = MIN_DECK)
  {
    if(input_deck_num < MAX_DECK)
    {
      deck_num = MIN_DECK;  //最小値
    }
    else if(input_deck_num > MAX_DECK)
    {
      deck_num = MAX_DECK;  //最大値
    }
    else
    {
      deck_num = input_deck_num;  //入力値
    }

    card_num = deck_num * DECK;

    deck = new int [card_num];
    p_deck = &deck[0];

    //配列初期化
    for(int i = 0; i < card_num; i++)
    {
      deck[i] = -1;
    }

    std::random_device rnd;   //乱数生成

    for(int i = 0; i < card_num; i++)
    {
      while(true)
      {
        int place = rnd()%(card_num);
        if(deck[place] == -1)
        {
          deck[place] = i%DECK;
          break; //ループを抜ける
        }
      }
    }
  }

  ~Deck_Pcard()
  {
    delete[] deck;
  }

  int hand_card()
  {
    int hand = p_deck[0];

    p_deck++;
    card_num--;
    return hand;
  }

  void show_card()
  {
    for(int i = 0; i < deck_num*DECK; i++)
    {
      std::cout << deck[i] << "";
    }
    std::cout << std::endl;
  }
};