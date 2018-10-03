package hotel.tests.services.stubs;

import hotel.entities.Room;
import hotel.repositories.RoomRepository;

import java.util.List;
import java.util.Optional;

public class RoomRepositoryStub implements RoomRepository {

    @Override
    public Room getById(Long id) {
        return null;
    }

    @Override
    public <S extends Room> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Room> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Room> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Room> findAll() {
        return null;
    }

    @Override
    public Iterable<Room> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Room entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Room> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
