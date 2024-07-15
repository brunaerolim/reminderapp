import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reminderapp.repositories.usecases.ReminderUseCase
import com.example.reminderapp.viewmodel.states.ReminderEvent
import com.example.reminderapp.viewmodel.states.ReminderState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val reminderUseCase: ReminderUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ReminderState(reminderUseCase.addReminder))
    private val state: StateFlow<ReminderState> = _state.asStateFlow()
    private var getAllReminderJob: Job? = null
    fun onEvent(event: ReminderEvent) {

        //passando os eventos para o useCase
        when (event) {
            is ReminderEvent.DeleteReminder -> {
                viewModelScope.launch {
                    reminderUseCase.deleteReminder(event.reminderModel)
                }
            }

            is ReminderEvent.AddReminder -> {
                _state.value = state.value.copy(addReminder = reminderUseCase.addReminder)
            }

            is ReminderEvent.GetAllReminders -> {
                getAllReminderJob?.cancel()
                getAllReminderJob = reminderUseCase.getReminder()
                    .onEach { _ ->
                        _state.value = state.value.copy()
                    }
                    .launchIn(viewModelScope)
            }
        }
    }
}