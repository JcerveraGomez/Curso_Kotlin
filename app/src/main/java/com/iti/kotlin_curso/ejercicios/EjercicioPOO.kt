import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.iti.kotlin_curso.components.customTopBar
import com.iti.kotlin_curso.ui.theme.Orange

// Define tus clases de datos
//almacena datos putos las Data Class
data class ItemMenu(val nombre: String, val precio: Double)

class Pedido(val items: MutableState<List<ItemMenu>> = mutableStateOf(listOf())) {
    fun agregarItem(item: ItemMenu) {
        items.value = items.value + item
    }
    fun totalPedido(): Double = items.value.sumOf { it.precio }
}
//Acceder a las clases desde la ui, se necesita un ViewModel
class RestauranteViewModel : ViewModel() {
    var pedido = mutableStateOf(Pedido())
        private set

    fun agregarAlPedido(item: ItemMenu) {
        pedido.value.agregarItem(item)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPedido(restauranteViewModel: RestauranteViewModel?=RestauranteViewModel(),navController:NavController) {
    val menu = listOf(
        ItemMenu("Pizza", 8.99),
        ItemMenu("Pasta", 6.99),
        ItemMenu("Ensalada", 5.99),
        ItemMenu("Sopa", 4.50),
        ItemMenu("Sandwich", 7.20),
        ItemMenu("Refresco", 1.99)
    )

    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        },
        content = {padding ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Menú", style = MaterialTheme.typography.headlineMedium)
                LazyColumn {
                    items(menu.size) { index ->
                        MenuItem(menu[index], restauranteViewModel!!)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                PedidoResumen(restauranteViewModel!!.pedido.value)
            }
        }
    )
}

@Composable
fun MenuItem(itemMenu: ItemMenu, restauranteViewModel: RestauranteViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(itemMenu.nombre)
            Text("${itemMenu.precio}€", color = Color.Gray)
        }
        Button(onClick = { restauranteViewModel.agregarAlPedido(itemMenu) }) {
            Text("Añadir", color = Color.White)
        }
    }
}

@Composable
fun PedidoResumen(pedido: Pedido) {
    Text("Resumen del Pedido", style = MaterialTheme.typography.headlineMedium)
    Text("Total: ${pedido.totalPedido()}€", color = Orange)
    pedido.items.value.forEach { item ->
        Text("- ${item.nombre}: ${item.precio}€")
    }

}

