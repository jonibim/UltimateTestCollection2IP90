class Building {
    String name;
    Room rooms[];
    Building (String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
    }
    
    void moveUser(User user, Room room, boolean isEntering) {
        Room hallway = rooms[0];
        if (!isEntering) {
            room.leave(user);
        } else if (room == hallway) {
            //as all rooms are connected to the hallway I assume this is what they meant, but could be wrong
            for (int i = 1; i < rooms.length; i++) {
                moveUser(user, rooms[i], false);
            }
            room.enter(user);
        } else if (room.hasLecturer() || user.isLecturer()) {
            moveUser(user, hallway, false);
            room.enter(user);
        }
        /*alternative:
        if (!isEntering) {
            room.leave(user);
        } else if (room == hallway || room.hasLecturer() || user.isLecturer()) {
            room.enter(user);
        }*/
    }
    
    @Override
    public String toString() {
        String result = "";
        for (Room room : rooms) {
            result += room.toString();
        }
        return result;
    }
}