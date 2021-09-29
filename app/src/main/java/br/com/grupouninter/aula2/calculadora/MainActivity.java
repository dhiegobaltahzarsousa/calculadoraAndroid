package br.com.grupouninter.aula2.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/*
 *
 * @author: Dhiego Balthazar - RU 2616931
 *
 */
public class MainActivity extends AppCompatActivity {
    //Metodo que cria a ActivityMain
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //metodo que permite a manipulação dos componentes da interface do usuario
        setContentView(R.layout.activity_main);

        //Inicio do bloco que pega as informações dos componentes da view e transforma-os em atributos manipuláveis.
        Button botao0 = (Button) findViewById(R.id.botao0);//findViewById -> pega o componente pelo id.
        Button botao1 = (Button) findViewById(R.id.botao1);
        Button botao2 = (Button) findViewById(R.id.botao2);
        Button botao3 = findViewById(R.id.botao3);
        Button botao4 = (Button) findViewById(R.id.botao4);
        Button botao5 = (Button) findViewById(R.id.botao5);
        Button botao6 = (Button) findViewById(R.id.botao6);
        Button botao7 = (Button) findViewById(R.id.botao7);
        Button botao8 = (Button) findViewById(R.id.botao8);
        Button botao9 = (Button) findViewById(R.id.botao9);
        Button soma = (Button) findViewById(R.id.soma);
        Button subtracao = (Button) findViewById(R.id.subtracao);
        Button divisao = (Button) findViewById(R.id.divisao);
        Button multiplicacao = (Button) findViewById(R.id.multiplicacao);
        Button igual = (Button) findViewById(R.id.igual);
        Button clear = (Button) findViewById(R.id.clear);
        Button ponto = (Button) findViewById(R.id.ponto);
        TextView tela = (TextView) findViewById(R.id.tela);
        //Fim do bloco

        //bloco de metodos que dão ação para os atributos da view
        botao0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//ao clicar faz algo
                tela.append(botao0.getText().toString());//adiciona o valor do botão no visor da calculadora
            }
        });

        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao1.getText().toString());
            }
        });
        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao2.getText().toString());
            }
        });
        botao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao3.getText().toString());
            }
        });
        botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao4.getText().toString());
            }
        });
        botao5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao5.getText().toString());
            }
        });
        botao6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao6.getText().toString());
            }
        });
        botao7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao7.getText().toString());
            }
        });
        botao8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao8.getText().toString());
            }
        });
        botao9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(botao9.getText().toString());
            }
        });
        subtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(subtracao.getText().toString());
            }
        });
        soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(soma.getText().toString());
            }
        });
        multiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(multiplicacao.getText().toString());
            }
        });

        divisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(divisao.getText().toString());
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.setText("");
            }
        });
        ponto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela.append(ponto.getText().toString());
            }
        });
        //ao apertar o botão igual, ele faz o calculo dos valores setados
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expressao = String.valueOf(tela.getText());
                String[] fatiado = new String[0];
                String sinal= "";
                Float resultado = new Float(0);
                Character a;
                Integer contadorSinais = new Integer(0);
                //faz a leitura da string digitada no visor da calculadora
                // int i -> indice que  percorre a string, character por character
                for (int i = 0; i < expressao.length(); i++) {
                    //variavel que pega o character da string -> usei para facilitar a comparação
                    //poderia usar direto expressao.charAt(i) dentro do if()
                    a = expressao.charAt(i);
                    //se a variavel a, é um símbolo ele adiciona um contador de sinal para limitar as operações
                    //e fatia a string pelo sinal contido colocando os valores numericos em 1 array
                    //a calculadora faz apenas um calculo por vez
                    if(a == 'X' || a == '/' || a == '+' || a == '-') {
                        contadorSinais += 1;
                        sinal = String.valueOf(a);
                        fatiado = expressao.split(sinal);

                    }
                }
                //se houver mais de um sinal operador, ele lança a informação a seguir
                if (contadorSinais > 1){
                    tela.setText("É PERMITIDA APENAS UMA OPERAÇÃO");
                }else {
                    //se não houver um operador ele aparece no visor a informação a seguir
                    if (contadorSinais < 1) {
                        tela.setText("ESCOLHA AO MENOS UMA OPERAÇÃO");
                    } else {
                        if(fatiado.length < 2){
                            // se houer apenas um valor ele aparece no visor a informação a seguir
                            tela.setText("É NECESSÁRIO 2 VALORES PARA OPERAÇÃO");
                        }else{

                            switch (sinal){
                                //se for X ele faz a multiplicação
                                //esses valores estão no campo de texto dos botões
                                case "X":       //faz o casting de array para Float
                                    resultado = Float.valueOf(fatiado[0]) * Float.valueOf(fatiado[1]);
                                    break;
                                    //se for / ele faz divisão
                                case "/":
                                    resultado = Float.valueOf(fatiado[0]) / Float.valueOf(fatiado[1]);
                                    break;
                                    //se for + ele soma
                                case "+":
                                    resultado = Float.valueOf(fatiado[0]) + Float.valueOf(fatiado[1]);
                                    break;
                                    //se for - ele subtrai
                                case "-":
                                    resultado = Float.valueOf(fatiado[0]) - Float.valueOf(fatiado[1]);
                                    break;
                            }
                            //apresenta o resultado no visor
                            tela.setText(String.valueOf(resultado));
                            contadorSinais = 0;//zera o contador para permitir outra operação sobre o resultado
                        }
                    }
                }
            }
        });
        //fim do bloco de ações
    }
}