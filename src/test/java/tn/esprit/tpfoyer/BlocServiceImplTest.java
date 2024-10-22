package tn.esprit.tpfoyer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BlocServiceImplTest {

    @Mock
    private BlocRepository blocRepository; // Le mock du repository

    @InjectMocks
    private BlocServiceImpl blocService; // Injecte le mock dans le service

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialiser les mocks
    }

    @Test
    public void testRetrieveAllBlocs() {
        // Données factices
        List<Bloc> blocList = new ArrayList<>();
        Bloc bloc1 = new Bloc();
        Bloc bloc2 = new Bloc();
        blocList.add(bloc1);
        blocList.add(bloc2);

        // Configurer le mock pour retourner cette liste
        when(blocRepository.findAll()).thenReturn(blocList);

        // Appeler la méthode à tester
        List<Bloc> result = blocService.retrieveAllBlocs();

        // Vérifications
        assertEquals(2, result.size());
        verify(blocRepository, times(1)).findAll(); // Vérifier que findAll() est bien appelé
    }

    @Test
    public void testRetrieveBloc() {
        // Créer un Bloc factice
        Bloc bloc = new Bloc();
        bloc.setIdBloc(1L);

        // Configurer le mock pour retourner ce bloc
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        // Appeler la méthode à tester
        Bloc result = blocService.retrieveBloc(1L);

        // Vérifications
        assertNotNull(result);
        assertEquals(1L, result.getIdBloc());
        verify(blocRepository, times(1)).findById(1L); // Vérifier que findById() est bien appelé
    }

    @Test
    public void testAddBloc() {
        // Créer un Bloc factice
        Bloc bloc = new Bloc();
        when(blocRepository.save(bloc)).thenReturn(bloc); // Simuler le comportement de save()

        // Appeler la méthode à tester
        Bloc result = blocService.addBloc(bloc);

        // Vérifier le résultat
        assertNotNull(result);
        verify(blocRepository, times(1)).save(bloc); // Vérifier que save() est bien appelé
    }

    @Test
    public void testRemoveBloc() {
        // Appeler la méthode à tester
        blocService.removeBloc(1L);

        // Vérifier que la méthode deleteById() a été appelée avec le bon argument
        verify(blocRepository, times(1)).deleteById(1L);
    }
}

