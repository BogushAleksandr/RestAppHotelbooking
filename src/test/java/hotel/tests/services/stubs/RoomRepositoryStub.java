package hotel.tests.services.stubs;

import hotel.entities.Room;
import hotel.repositories.RoomRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

public class RoomRepositoryStub implements RoomRepository {

    private List<Room> storage;

    public RoomRepositoryStub() {
        this.storage = new ArrayList<>();
    }

    @Override
    public <S extends Room> S save(S entity) {
        storage.add(entity);
        return entity;
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
        return storage;
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
