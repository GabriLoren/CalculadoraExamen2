package com.example.calculadoraexamen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import com.example.calculadoraexamen2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var actualizarOperaciones = ""
        var valorEntrante = ""
        var valor1 = 0.0
        var valor2: Double
        var operacion = ""
        var resultado: Double
        var resultadoInt: Int

        var listaNumeros = mutableListOf<String>()
        var listaOperandos = mutableListOf<String>()
        var numero = ""


        fun calcular(): String {
            var listaOperandosMetodo = mutableListOf<String>()
            var resultado = ""
            var contador = 0
            var contadorOperandos = 0
            var segundoNumero = ""


//            var lista = binding.textViewResultado.text.toString().split("+", "-", "*")
//
//            if (listaNumeros.size == listaOperandos.size && listaOperandos.size > 0) {
//
//                listaOperandos.removeAt(listaOperandos.lastIndex)
//
//            } else {
//
//                if (listaOperandos.size < 1 && listaNumeros.size > 0) {
//
//                    listaNumeros.removeAt(0)
//                }
//
//                listaNumeros.add(listaOperandos.lastIndex + 1, lista.get(lista.lastIndex))
//            }


            Log.i("Etiqueta", "size operandos " + listaOperandos.size)
            Log.i("Etiqueta", "size numeros " + listaNumeros.size)
            Log.i("Etiqueta", "lista numeros " + listaNumeros.toString())

            listaOperandos.forEachIndexed { index, elemento ->

//                Log.i("Etiqueta", "index " + it + "del elemento " + elemento)

                if (elemento.equals("*")) {

                    var calculo =
                        listaNumeros.get(index - contador).toDouble() * listaNumeros.get(
                            index + 1 - contador
                        ).toDouble()

                    listaNumeros.removeAt( index + 1)

                    listaNumeros.removeAt( index)

                    listaNumeros.add( index, calculo.toString())


                    Log.i("Etiqueta", "elimino el " + listaOperandos.get( index))

//                    listaOperandos.removeAt( it.toInt())

                    Log.i("Etiqueta", "elimino la posicion " +  index)

                    Log.i("Etiqueta", "lista de operandos" + listaOperandos.toString())

                    contador++

                }

            }


            listaOperandos.forEachIndexed { index, elemento ->
                contadorOperandos = 0
                var calculo = 0.0
                when (elemento) {
                    "+" -> calculo =
                        listaNumeros.get(index - contadorOperandos).toDouble() + listaNumeros.get(
                            index + 1 - contadorOperandos
                        ).toDouble()

                    "-" -> calculo =
                        listaNumeros.get(index).toDouble() - listaNumeros.get(
                            index + 1
                        ).toDouble()
                }

                listaNumeros.removeAt(index + 1)
                listaNumeros.removeAt(index)
                listaOperandos.removeAt(index)

                listaNumeros.add(0, calculo.toString())

                Log.i("Etiqueta", "la lista de numeros " + listaNumeros.toString())

                contadorOperandos++
            }



            return listaNumeros.get(listaNumeros.lastIndex)
        }


//        binding.textViewResultado.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                // Este método se llama para notificar que algo está a punto de cambiar en el texto
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                // Este método se llama para notificar que el texto ha cambiado
//
////                binding.textViewBotonPulsado.text = binding.textViewResultado.text
//
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                // Este método se llama después de que el texto ha cambiado
//
//                // Realiza acciones con el nuevo texto, por ejemplo, puedes imprimirlo
//
//
////                binding.textViewBotonPulsado.text = calcular()
//            }
//        })


        binding.button9.setOnClickListener {

            Log.i("Etiqueta", "entra en 9")
            valorEntrante += "9"
            numero += "9"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(numero)


        }

        binding.button8.setOnClickListener {
            valorEntrante += "8"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        binding.button7.setOnClickListener {
            valorEntrante += "7"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        binding.button6.setOnClickListener {
            valorEntrante += "6"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        binding.button5.setOnClickListener {
            valorEntrante += "5"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        binding.button4.setOnClickListener {
            valorEntrante += "4"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        binding.button3.setOnClickListener {
            valorEntrante += "3"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        binding.button2.setOnClickListener {
            valorEntrante += "2"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        binding.button1.setOnClickListener {
            valorEntrante += "1"
            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        binding.button0.setOnClickListener {
            valorEntrante += "0"

            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)

        }
        //operaciones
        binding.buttonMas.setOnClickListener {

            listaOperandos.add("+")

            listaNumeros.add(valorEntrante)

            valorEntrante = ""

            numero += "+"

            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(numero)
        }

        binding.buttonMenos.setOnClickListener {

            if (operacion == "=" || valor1 == 0.0) {
                operacion = "-"
                binding.textViewResultado.text = Editable.Factory.getInstance()
                    .newEditable("")
                try {
                    valor1 = valorEntrante.toDouble()
                    valorEntrante = ""
                } catch (_: NumberFormatException) {

                }
            } else {

                resultado = 0.0
                try {
                    valor2 = valorEntrante.toDouble()
                    when (operacion) {
                        "x" -> resultado = valor1 * valor2
                        "/" -> resultado = valor1 / valor2
                        "+" -> resultado = valor1 + valor2
                        "-" -> resultado = valor1 - valor2
                    }
                    valor1 = resultado
                    operacion = "-"
                    resultadoInt = resultado.toInt()
                    if (resultado == resultadoInt.toDouble())
                        valorEntrante = resultadoInt.toString()
                    else valorEntrante = resultado.toString()


                    binding.textViewResultado.text = Editable.Factory.getInstance()
                        .newEditable(valorEntrante)
                    valorEntrante = ""
                } catch (_: java.lang.NumberFormatException) {

                }

            }
        }

        binding.buttonX.setOnClickListener {
            listaOperandos.add("*")

            listaNumeros.add(valorEntrante)

            valorEntrante = ""

            numero += "x"

            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(numero)

        }


        binding.buttonDivision.setOnClickListener {

        }


        binding.buttonIgual.setOnClickListener {

            Log.i("Etiqueta", "lista operandos" + listaOperandos.toString())


            if (!valorEntrante.equals("")) {
                listaNumeros.add(valorEntrante)
            }

            binding.textViewBotonPulsado.text = calcular()

        }

        binding.buttonC.setOnClickListener {
            resultado = 0.0
            valorEntrante = ""
            valor1 = 0.0
            valor2 = 0.0
            operacion = ""

            binding.textViewResultado.text = Editable.Factory.getInstance()
                .newEditable(valorEntrante)
        }

    }
}